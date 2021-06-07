package com.psujek.dll;

/*
    More details:
        http://docs.attachmate.com/infoconnect/ented/9.2/pdf_docs_infoconnect/ihllapi_prog_ref.pdf
 */
public class PSCApiRetrunCodes {
    static final int
            HLL_SUCCESS = 0,
            HLL_INVALIDPSID = 1,
            HLL_INVALIDPARAMETER = 2,
            HLL_SESSIONOCCUPIED = 4,
            HLL_TIMEOUT = 4,  /* e.g. Wait (XCLOCK/XSYSTEM)*/
            HLL_PSLOCKED = 5,  /* e.g. ConnectPS */
            HLL_PROTECTED = 5,
            HLL_FIELDSIZEMISMATCH = 6,  /* e.g. CopyFieldToString */
            HLL_DATATRUNCATED = 6,  /* e.g. CopyStringToField */
            HLL_INVALIDPSPOSITION = 7,
            HLL_NOPRIORSTARTKEYSTROKE = 8,
            HLL_NOPRIORSTARTHOSTNOTIFY = 8,
            HLL_SYSTEMERROR = 9,
            HLL_RESOURCEUNAVAILABLE = 11,
            HLL_SEARCHSTRINGNOTFOUND = 24,  /* e.g. SearchField */
            HLL_UNFORMATTEDHOSTPS = 24,  /* e.g. CopyFieldToString */
            HLL_NOSUCHFIELD = 24,  /* e.g. FindFieldPosition */
            HLL_NOHOSTSESSIONUPDATE = 24,  /* new code for QueryHostUpdate */
            HLL_KEYSTROKESNOTAVAILABLE = 25,
            HLL_HOSTSESSIONUPDATE = 26,  /* end of Pause */
            HLL_KEYSTROKEQUEUEOVERFLOW = 31,
            HLL_MEMORYUNAVAILABLE = 101,  /* cf StartKSIntercept */
            HLL_DELAYENDEDBYCLIENT = 102,  /* Wait, Pause, GetKey */
            HLL_UNCONFIGUREDPSID = 103,  /* Connect, Intercept */
            HLL_NOEMULATORATTACHED = 104,  /* keystroke intercept, etc */
            HLL_WSCTRLFAILURE = 105;
}
