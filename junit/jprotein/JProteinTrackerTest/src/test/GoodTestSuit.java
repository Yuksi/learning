package test;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.BadTestCategory;
import test.GoodTestCategory;
import test.HelloJUnitTest;
import test.TrackingServiceTest;

@RunWith(Categories.class)
@IncludeCategory(GoodTestCategory.class)
@ExcludeCategory(BadTestCategory.class)
@Suite.SuiteClasses({
	HelloJUnitTest.class, 
	TrackingServiceTest.class
})
public class GoodTestSuit {

}
