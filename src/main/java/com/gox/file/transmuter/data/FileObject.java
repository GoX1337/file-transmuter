package com.gox.file.transmuter.data;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class FileObject {

    private Map<String, String> keyValues = new HashMap<>();

    public void addAttribute(String key, String value){
        keyValues.put(key, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        keyValues.forEach((k, v) -> sb.append("\t").append(k).append(": ").append(v).append("\n"));
        return sb.toString();
    }
}
