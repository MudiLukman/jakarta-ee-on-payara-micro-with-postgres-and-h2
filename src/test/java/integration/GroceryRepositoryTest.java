package integration;

import com.kontrol.javaeedemo.grocery.Grocery;
import com.kontrol.javaeedemo.grocery.GroceryRepository;
import com.kontrol.javaeedemo.grocery.GroceryService;
import com.kontrol.javaeedemo.grocery.converters.UUIDConverter;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class GroceryRepositoryTest {

    @Inject
    GroceryService groceryService;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "enterprise-test.jar")
                .addClasses(GroceryService.class, GroceryRepository.class, Grocery.class, UUIDConverter.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml");
    }

    @Test
    public void testCreate() {
        Grocery grocery = new Grocery();
        grocery.name = "Zucchini";
        grocery.price = 10;

        Grocery result = groceryService.create(grocery);

        Assert.assertNotNull(result);
        Assert.assertEquals(grocery.name, result.name);
        Assert.assertEquals(grocery.price, result.price);
    }
}
