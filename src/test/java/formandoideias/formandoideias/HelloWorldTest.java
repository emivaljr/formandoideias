package formandoideias.formandoideias;

import org.testng.annotations.Test;

import br.com.formandoideias.HelloWorld;

public class HelloWorldTest
{
   @Test
   public void testGetText() {
      HelloWorld fixture = new HelloWorld();
      assert "Hello World!".equals(fixture.getText());
   }
}
