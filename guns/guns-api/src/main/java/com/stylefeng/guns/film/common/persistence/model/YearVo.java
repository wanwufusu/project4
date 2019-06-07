package com.stylefeng.guns.film.common.persistence.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈影片年代〉
 *
 * @author Ruimingz
 * @create 2019/6/6
 * @since 1.0.0
 */
@Data
public class YearVo implements Serializable {
    private String yearId;
    private String yearName;
    private boolean isActive = false;

    @JsonProperty(value = "isActive")
    public boolean getIsActive() {
        return isActive;
    }
}
