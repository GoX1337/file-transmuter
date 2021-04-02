package com.gox.file.transmuter.data;

import java.util.LinkedHashMap;
import java.util.Map;

public class FileObject extends LinkedHashMap<String, String> {

    public void addAttribute(String key, String value){
        this.put(key, value);
    }

    public FileObject(Map<String, String> map){
        super(map);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        this.forEach((k, v) -> sb.append("\t").append(k).append(": ").append(v).append("\n"));
        return sb.append("]").toString();
    }
}
