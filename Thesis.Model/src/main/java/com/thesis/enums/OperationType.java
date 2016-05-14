package com.thesis.enums;

public enum OperationType {
    THESIS_APPEAL("Tez Başvuru"),
    NEW_COMMENT("Yeni Yorum"),
    NEW_STUDENT_ACTIVITY("Yeni öğrenci aktivitesi"),
    NEW_THESIS_SUGGESTION("Yeni tez önerisi"),
    ACCEPTED_THESIS_SUGGESTION("Tez önerisi kabulü"),
    DISMISSED_THESIS_SUGGESTION("Tez önerisi reddi"),
    UPLOAD_FILE("Dosya yükleme");

    private String value;

    OperationType(String value ) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
