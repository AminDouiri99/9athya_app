package com.example.a9athya;

import android.provider.BaseColumns;

public class kathyaContract {
    private kathyaContract(){}
    public static final class kathyaEntry implements BaseColumns {
        public static final String TABLE_NAME ="kathya_list";
        public static final String COL_NAME="name";
        public static final String COL_AMOUNT="amount";
        public static final String COL_TIMESTAMP="timestamp";

    }
}
