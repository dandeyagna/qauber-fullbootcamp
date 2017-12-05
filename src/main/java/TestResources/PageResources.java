package TestResources;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageResources {
WebDriver dr;

    public LoginPage getLoginpage() {
        return loginpage;
    }

    private LoginPage loginpage;
    private AddingEntity addingEntity;
    private CreatingIDInformation creatingIDInformation;
    private CreatingSubjectInformation creatingSubjectInformation;
    private CreatingDistribution creatingDistribution;
    private VehicalDetails vehicalDetails;
    private AddPhotos addPhotos;
    private IdentifiersPage identifiersPage;
    private ViewReports viewReports;

    public ViewReports getViewReports() {
        return viewReports;
    }

    public IdentifiersPage getIdentifiersPage() {
        return identifiersPage;
    }



    public CreatePublishReport getCreatePublishReport() {
        return createPublishReport;
    }

    private CreatePublishReport createPublishReport;

    public AddPhotos getAddPhotos() {
        return addPhotos;
    }


    public VehicalDetails getVehicalDetails() {
        return vehicalDetails;
    }



    public CreatingSubjectInformation getCreatingSubjectInformation() {
        return creatingSubjectInformation;
    }


    public AddingEntity getAddingEntity() {
        return addingEntity;
    }

    public CreatingIDInformation getCreatingIDInformation() {
        return creatingIDInformation;
    }

    public CreatingDistribution getCreatingDistribution() {
        return creatingDistribution;
    }

    public PageResources(WebDriver dr){
    this.dr=dr;
    loginpage = new LoginPage(dr);
    addingEntity =new AddingEntity(dr);
    creatingSubjectInformation = new CreatingSubjectInformation(dr);
    creatingIDInformation =new CreatingIDInformation(dr);
    creatingDistribution =new CreatingDistribution(dr);
    vehicalDetails =new VehicalDetails(dr);
    addPhotos = new AddPhotos(dr);
    createPublishReport = new CreatePublishReport(dr);
    identifiersPage =new IdentifiersPage(dr);
    viewReports=new ViewReports(dr);

}

}
