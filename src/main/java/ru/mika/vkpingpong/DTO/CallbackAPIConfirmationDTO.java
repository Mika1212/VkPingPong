package ru.mika.vkpingpong.DTO;

public class CallbackAPIConfirmationDTO {
    private String type;
    private int group_id;

    CallbackAPIConfirmationDTO(String type, int group_id) {
        this.type = type;
        this.group_id = group_id;
    }

    CallbackAPIConfirmationDTO() {}

        public String getType() {
        return type;
    }

    public int getGroup_id(){
        return group_id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }
}
