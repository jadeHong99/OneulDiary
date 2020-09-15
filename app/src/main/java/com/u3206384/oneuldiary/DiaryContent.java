package com.u3206384.oneuldiary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DiaryContent {
    String title;
    String content;
    LocalDate date;

    public DiaryContent(LocalDate date, String title, String content){
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public String getTitle(){
        return this.title;
    }

    public String getContent(){
        return this.content;
    }

    public String getDate(){
        return this.date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

}
