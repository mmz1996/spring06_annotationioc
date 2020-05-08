注解配置和xml配置，实现的功能都是一样的，都是需要程序间的耦合，只是配置的形式不一样。

**注解方式**
用于创建对象
用于注入数据的
用于改变范围的
用于生命周期相关的


**用于创建对象的**
在xml文件编写一个bean标签是一样的
@Component 把当前类对象存入spring容器
当我们不写时，key默认值的当前类名，首字母小写，从而获取对象
还需要在bean.xml配置，注解的开启

```bash
    <context:component-scan base-package="com.mmz"></context:component-scan>
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200508225730276.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM2MzQ0Nzcx,size_16,color_FFFFFF,t_70)


```bash
@Component(value = "accountService")
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao = new AccountDaoImpl();

    public AccountServiceImpl() {
        System.out.println("对象创建了");
    }

    public void saveAccount(){
        accountDao.saveAccount();
    }
}
```
当然也可以用value改变注入的key

@Controller @Service @Repository
以上三个注解的作用和属性，与@Component一模一样的。

他们三个是Spring框架为我们提供明确三层的使用的注解，使我们的三层对象更加清晰

@Controller 表现层
@Service 业务层
@Repository 持久层

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200508230213375.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM2MzQ0Nzcx,size_16,color_FFFFFF,t_70)


**用于注入数据**
在xml文件中bean标签写一个property标签是一样的
@Autowired 自动按照类型注入，只要容器中有唯一的bean对象类型和变量类型匹配就可以注入成功
出现位置：可以是成员变量上，也可以是方法上。
细节：在使用注解注入的时候，set方法就不是必须的了
如果ioc容器中没有任何的bean的类型和要注入的变量类型匹配，则报错。
如果ioc容器中有多个容器匹配时，首先根据数据类型选定集合，在通过变量名称中在集合中搜寻对象。


@Qualifier 作用：在按照类中注入的基础之上在按照名称注入，它在类成员注入的时候不能单独使用。但是给方法参数注入时可以。
value注入指定的bean
注意：不能单独使用！要和autowired联合使用

@Resource作用：直接按照bean的id注入，它可以独立使用。
属性：name：用于指定bean的id

以上三个注解都只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现
另外集合类型的注入只通过xml来实现。

@Value注解，用于注解基本类型和String类型的数据，属性也叫value，用于指定数据的值。它可以使用Spring中的SpEL，Spring的el表达式
SpEL的写法，${表达式}



**用于改变范围的**
他们的作用在bean标签中使用scope属性实现的功能是一样的
Scope 作用：用于指定bean的范围
属性：value指定范围的取值
常用取值 singleton/prototype


**用于生命周期**
在bean标签中使用init-method 与 destroy-method是一样的
了解 
@PreDestroy 作用用于指定销毁方法
@PostConstruct 作用用于指定初始化方法


```bash
    @PostConstruct
    public void init(){
        System.out.println("初始化方法");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("销毁方法");
    }
```
