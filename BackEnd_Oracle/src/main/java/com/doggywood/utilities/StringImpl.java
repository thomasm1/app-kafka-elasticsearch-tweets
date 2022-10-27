package com.doggywood.utilities;

import java.util.Arrays;

public class StringImpl {
    private StringService stringService;

    public void setStringService(StringService stringService) {
        this.stringService = stringService;
    }
    // FUNC 0
    public String  renderFullName(String uName, String lName) {
        String[] conc = {uName, lName };
        String fullName = "";
//         return Arrays.stream(conc).reduce(String::concat).orElse("");
        for(String name: conc) {
            fullName += name+" ";
        }
        // localCacheService.storeUserFullName(fullName);
        return fullName.trim();
    }

}
