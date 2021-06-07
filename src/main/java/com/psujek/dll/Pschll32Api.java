package com.psujek.dll;

import com.sun.jna.Library;
import com.sun.jna.Native;

/*
    More details about dll:
        https://docs.attachmate.com/extra/x-treme/apis/pcshll.pdf


 */
public interface Pschll32Api extends Library {
    Pschll32Api instance = (Pschll32Api) Native.loadLibrary("pschll32.dll", Pschll32Api.class);

    int hllapi(int[] func, byte[] data, int[] length, int[] retC);
}
