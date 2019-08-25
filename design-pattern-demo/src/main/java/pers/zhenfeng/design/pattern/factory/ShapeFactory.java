package pers.zhenfeng.design.pattern.factory;

/**
 * @author Grow-Worm
 * @date 2019/06/30
 */
class ShapeFactory {

    static Shape getShape(Class<? extends Shape> shape) {
        try {
            return shape.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
