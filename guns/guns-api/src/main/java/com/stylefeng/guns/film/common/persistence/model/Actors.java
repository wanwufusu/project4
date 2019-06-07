package com.stylefeng.guns.film.common.persistence.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/6/7
 * @since 1.0.0
 */
@Data
public class Actors implements Serializable {
    private Director director;
    private List<Actor> actors;
}
