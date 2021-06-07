package com.psujek.dll;

import com.psujek.utility.Conversion;
import com.psujek.utility.Position;

public class Pschll32Proxy implements AutoCloseable {
    static final Pschll32Api api = Pschll32Api.instance;

    // change it in case of different dimensions
    //TODO probably could be read automatically via Query Session Status
    static final int rows = 24, columns = 80;

    private final String sessionName;

    private int func, len, pos;
    private String data;

    public Pschll32Proxy(String sessionName) {
        this.sessionName = sessionName;
        connect();
    }

    public Position setPosition(int position) {
        func = PSCApiMethodCodes.SET_CURSOR_POSITION;
        data = "";
        len = 0;
        pos = position;
        sendMessage();
        return Position.fromPos(pos, columns);
    }

    public Position setPosition(int row, int col) throws IllegalArgumentException {
        if((row <= rows && row >= 1) || (col <= columns && col >= 1)) {
            throw new IllegalArgumentException(String.format("Rows(actual:%d, max:%d) or Columns(actual:%d, max:%d) out of range", row, rows, col, columns));
        }
        return setPosition((row - 1) * columns + col);
    }

    public void send(String data) {
        this.data = data;
        pos = 0;
        len = data.length();
        func = PSCApiMethodCodes.SEND_KEY;
    }

    public void sendAt(String data, int row, int col) {
        setPosition(row, col);
        send(data);
    }

    public Position searchString(String text, int startPosition, int len) {
        data = text;
        pos = startPosition;
        this.len = len;
        func = PSCApiMethodCodes.SEARCH_PRESENTATION_SPACE;
        int returnCode = sendMessage();
        if(returnCode == PSCApiRetrunCodes.HLL_SEARCHSTRINGNOTFOUND) return new Position(-1, -1);
        return Position.fromPos(pos, columns);
    }

    @Override
    public void close() throws Exception {
        disconnect();
    }

    private void connect() {
        func = PSCApiMethodCodes.CONNECT_PRESENTATION_SPACE;
        len = 4;
        pos = 0;
        data = sessionName;
        sendMessage();
    }

    private void disconnect() {
        func = PSCApiMethodCodes.DISCONNECT_PRESENTATION_SPACE;
        len = 4;
        pos = 0;
        data = sessionName;
        sendMessage();
    }

    private int sendMessage() {
        byte[] byteData = Conversion.convertStringToByteArray(data);
        int[] function = new int[] {func};
        int[] length = new int[] {len};
        int[] position = new int[] {pos};
        int returnCode = api.hllapi(function, byteData, length, position);
        len = length[0];
        pos = position[0];
        data = Conversion.convertByteArrayToString(byteData);
        return returnCode;
    }
}
