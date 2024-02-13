package com.programmingtechie.inventoryservice.enums;

import com.programmingtechie.inventoryservice.errors.InventoryState;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum InventoryEnum {

    DATA_FETCHED_SUCCESSFULLY(InventoryState.DATA_FETCHED_SUCCESS_MESSAGE, InventoryState.DATA_FETCHED_SUCCESS_CODE);

    private final String message;
    private final String code;

    public String getSuccessCode() {
        return "S09" + code;
    }

    public String getErrorCode() {
        return "E09" + code;
    }
}
