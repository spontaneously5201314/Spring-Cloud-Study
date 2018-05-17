1.Spring中Bean的注入：  

    １．使用@Configuration注解生成一个配置类，然后在其中直接用@Bean注解生成类　　
    ２．实现FactoryBean<T>接口，其实现的方法中getObject()返回的就是对象，然后在配置类中获取　　
    ３．使用@Component，@Repository，@Service，@Controller注入
    ４．使用@Resource(JSR-250)/@Inject(JSR-330)注解注入，这两个注解是JSR不同版本带的
    
    
2.Spring中Bean的初始化和销毁方法：  
    
    １．使用@Bean注解中的initMethod和destroyMethod属性　　
    ２．使用@PostConstruct和@PreDestroy注解实现　　
    ３．继承Spring的InitializingBean, DisposableBean接口并实现afterPropertiesSet和destroy方法  
    
3.当出现多个备选的Bean的时候怎么解决？　　

    １．在需要使用Bean的地方使用@Qualifier注解指定需要注入的那个Bean
    ２．在申明Bean的时候使用@Primary注解指定  
  
4.使用ApplicationContext的三种方法：　　
    
    １．使用@Autowired注解
    ２．实现ApplicationContextAware接口
    ３．直接使用带参构造函数，参数就是ApplicationContext，Spring4.3之后默认会在容器中寻找相应的bean然后注入，
       但是这种方法有缺点，只能有一个构造函数．该方法的实现原理是使用了Spring自带的BeanPostProcessor  
  
5.BeanPostProcessor，BeanFactoryPostProcessor和BeanDefinitionRegistryPostProcessor

    1.BeanFactoryPostProcessor的调用时机比BeanPostProcessor早
    2.BeanPostProcessor主要是在bean初始化前后调用，主要有两个方法(postProcessBeforeInitialization/postProcessAfterInitialization)需要实现，详细看MyBeanPostProcessor
    3.BeanFactoryPostProcessor主要是在bean工厂初始化之后调用，主要实现方法是postProcessBeanFactory，并且只触发一次
    4.BeanDefinitionRegistry可以动态的注入bean，详细案例看MyBeanDefinitionRegistryPostProcessor