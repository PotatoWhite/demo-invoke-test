# Mockito를 이용한 Aspect Unit Test
- Sping Component의 Public Method의 실제 동작여부를 확인한다.

### @SpyBean
- Unit Test의 @Autowired 와 함께 확인이 필요한 Component에 사용한다.
    ```java
    @Autowired
    @SpyBean
    DemoService demoService;
    ```

### initialize
- Mockito를 활성화 한다.
    ```java
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    ```
  
### 호출 여부 확인 : org.mockito.Mockito.verify
- times를 이용해 실제 호출이 되는지 확인이 필요한 Method와 호출 횟수를 지정한다. 
  
    ```java
    @Test
    public void test() throws Throwable {
        String result = demoController.hello();
        assertThat(result, is("Hello World"));
    
        verify(demoService, times(1)).getHello();
        verify(demoAspect, times(1)).intercept(any());
        verify(demoAspect, times(2)).doSome();
    }
    ```