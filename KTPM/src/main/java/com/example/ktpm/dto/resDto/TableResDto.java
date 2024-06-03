package com.example.ktpm.dto.resDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TableResDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("number")
    private Long number;
    @JsonProperty("area")
    private String area;
    @JsonProperty("status")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String are) {
        this.area = are;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
