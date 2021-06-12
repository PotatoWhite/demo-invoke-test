package me.potato.demoInvokeCheck;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

@SpringBootTest
class DemoAspectUnittestApplicationTests {

	@Autowired
	@SpyBean
	DemoService demoService;

	@Autowired
	DemoController demoController;

	@Autowired
	@SpyBean
	DemoAspect demoAspect;

	@BeforeEach
	public void initialize() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void test() throws Throwable {
		String result = demoController.hello();
		assertThat(result, is("Hello World"));

		verify(demoService, times(1)).getHello();
		verify(demoAspect, times(1)).intercept(any());
		verify(demoAspect, times(2)).doSome();
	}
}
