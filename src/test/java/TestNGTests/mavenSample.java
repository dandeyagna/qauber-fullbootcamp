package TestNGTests;

import org.testng.annotations.Test;

public class mavenSample {

        @Test(groups={"functional","login"},description="This is my first Test Case")
        public void loginTest() {
            System.out.println("Logging in ..");
        }

        @Test(dependsOnGroups={"functional"})
        public void signOut() {
            System.out.println("Signing Out ...");
        }

        @Test(groups={"functional"},dependsOnMethods={"loginTest"})
        public void addReport() {
            System.out.println("Adding Report ... ");
        }

        @Test(groups={"functional"},dependsOnMethods={"loginTest"})
        public void searchReport() {
            System.out.println("Searching Report ... ");
        }
    }

