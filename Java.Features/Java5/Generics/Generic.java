public class Generic {
  /*
   * 泛型类
   * 泛型类和泛型接口的类型变量都是定义在类型级别的，其作用域可覆盖成员变量和成员方法。
   * Test1<T>中，T是一个无限定的类型变量，类型擦除时用 Object 替换。
   */
  class Test1<T> {
    private T value;
    public T getValue() {
      return value;
    }

    public void setValue(T value) {
      this.value = value;
    }
  }

  /*
   * 如果类型变量有限定，那么原始类型就用第一个边界的类型变量来替换。
   * 以下类原始类型就是Comparable
   *
   * 如果 Test2 这样声明public class Test2<T extends Serializable&Comparable>
   * 那么原始类型就用Serializable替换，而编译器在必要的时要向Comparable插入强制类型转换。
   *
   * 为了提高效率，应该将标签（tagging）接口（即没有方法的接口）放在边界限定列表的末尾。
   */
  public class Test2<T extends Comparable & Serializable> {}


  public static class Test3 {
    // 泛型方法
    public static <T> T add(T x,T y){
      return y;
    }
    // 泛型方法的类型参数定义在方法签名中
    // <T>表示这是一个泛型方法
    // T是仅作用于 getObject方法 上的类型变量
    public <T> T getObject(Class<T> clz) throws Exception {
      T t = clz.newInstance();
      return t;
    }
  }
  // 泛型 接口
  public interface Interface1<T1, T2> {
    void doSomething(T1 t1, T2 t2);
  }

  public static class Test4<T2> implements Interface1<String, T2> {

    // 如果实现一个泛型接口，可以在定义时直接传入具体的类型（如T1传入String），
    // 也可以继续传入一个类型，待使用时再确认具体的类型。
    @Override
    public void doSomething(String s, T2 t2) {
      System.out.println(s);
      System.out.println(t2);
    }
  }

  public static void main(String[] args) {
    try {
      ArrayList<String> arrayList1 = new ArrayList<String>();
      arrayList1.add("abc");
      ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
      arrayList2.add(123);

      // 类型擦除
      System.out.println(arrayList1.getClass());
      System.out.println(arrayList2.getClass());
      System.out.println(arrayList1.getClass() == arrayList2.getClass());
      // 输出 :
      // class java.util.ArrayList
      // class java.util.ArrayList
      // true
      // 说明泛型类型String和Integer都被擦除掉了，只剩下了原始类型。

      arrayList2.getClass().getMethod("add", Object.class).invoke(arrayList2, "asd");
      // 利用反射 调用add方法的时候，却可以存储字符串。
      // 这说明了Integer泛型实例在编译之后被擦除了，只保留了原始类型。


      // 不指定泛型的时候
      int i = Test3.add(1, 2); //两个参数都是Integer，所以T为Integer类型
      Number f = Test3.add(1, 1.2); //两个参数是Integer 和 Float，所以取同一父类的最小级，为Number
      Object o = Test3.add(1, "asd");//两个参数一个是Integer 和 String，所以取同一父类的最小级，为Object

      // 指定泛型的时候
      int a = Test3.<Integer>add(1, 2);  //指定了Integer，所以只能为Integer类型或者其子类
      //int b = Test3.<Integer>add(1, 2.2);  //编译错误，指定了Integer，不能为Float
      Number c = Test3.<Number>add(1, 2.2); //指定为Number，所以可以为Integer和Float

      new Test3().getObject(String.class);

      Interface1<String, Integer> integerInterface1 = new Test4<>();
      integerInterface1.doSomething("test", 123);

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

}
