package com.stylefeng.guns.film.common.persistence.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈片源〉
 *
 * @author Ruimingz
 * @create 2019/6/6
 * @since 1.0.0
 */
@Data
public class SourceVo implements Serializable {
    private String sourceId;
    private String sourceName;
    private boolean isActive = false;

    @JsonProperty(value = "isActive")
    public boolean getIsActive() {
        return isActive;
    }
}
