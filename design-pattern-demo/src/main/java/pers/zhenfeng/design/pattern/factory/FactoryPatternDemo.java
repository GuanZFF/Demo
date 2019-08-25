package pers.zhenfeng.design.pattern.factory;

import java.util.Objects;

/**
 * @author Grow-Worm
 * @date 2019/06/30
 */
public class FactoryPatternDemo {

    public static void main(String[] args) {
        Objects.requireNonNull(ShapeFactory.getShape(Rectangle.class)).draw();
        Objects.requireNonNull(ShapeFactory.getShape(Square.class)).draw();
        Objects.requireNonNull(ShapeFactory.getShape(Circle.class)).draw();
    }

}
