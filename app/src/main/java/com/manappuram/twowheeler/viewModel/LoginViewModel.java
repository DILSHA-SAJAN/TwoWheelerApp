package com.manappuram.twowheeler.viewModel;



import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.manappuram.twowheeler.repository.LoginRepository;
import com.manappuram.twowheeler.request.AddCustDocumentRequest;
import com.manappuram.twowheeler.request.AddCustomerRequest;
import com.manappuram.twowheeler.request.AddDealerDocumentRequest;
import com.manappuram.twowheeler.request.AddDealerRequest;
import com.manappuram.twowheeler.request.BaseRequest;
import com.manappuram.twowheeler.request.CIBILRequest;
import com.manappuram.twowheeler.request.CustIDCreationRequest;
import com.manappuram.twowheeler.request.DealerIDCreationRequest;
import com.manappuram.twowheeler.request.DealerLoginRequest;
import com.manappuram.twowheeler.request.DistrictRequest;
import com.manappuram.twowheeler.request.DocViewRequest;
import com.manappuram.twowheeler.request.EditCustomerRequest;
import com.manappuram.twowheeler.request.LoginRequest;
import com.manappuram.twowheeler.request.OtherVerticalsRequest;
import com.manappuram.twowheeler.request.RejectCustomerRequest;
import com.manappuram.twowheeler.request.ScoreCardRequest;
import com.manappuram.twowheeler.request.StateFromPinRequest;
import com.manappuram.twowheeler.request.ViewDealerListRequest;
import com.manappuram.twowheeler.response.AddCustDocumentResponse;
import com.manappuram.twowheeler.response.AddCustomerResponse;
import com.manappuram.twowheeler.response.AddDealerResponse;
import com.manappuram.twowheeler.response.BaseResponse;
import com.manappuram.twowheeler.response.CustIDCreationResponse;
import com.manappuram.twowheeler.response.DealerIDCreationResponse;
import com.manappuram.twowheeler.response.DealerLoginResponse;
import com.manappuram.twowheeler.response.DistrictResponse;
import com.manappuram.twowheeler.response.DocViewResponse;
import com.manappuram.twowheeler.response.IndividualCustResponse;
import com.manappuram.twowheeler.response.IndividualDealerResponsse;
import com.manappuram.twowheeler.response.LoginResponse;
import com.manappuram.twowheeler.response.MisReportResponse;
import com.manappuram.twowheeler.response.OtherVerticalsResponse;
import com.manappuram.twowheeler.response.Output.CibilScoreOutput;
import com.manappuram.twowheeler.response.PostOfficeResponse;
import com.manappuram.twowheeler.response.QuestionnaireResponse;
import com.manappuram.twowheeler.response.StateResponse;
import com.manappuram.twowheeler.response.TenureResponse;
import com.manappuram.twowheeler.response.ViewCustomerListResponse;
import com.manappuram.twowheeler.response.ViewDealerListResponse;

public class LoginViewModel extends ViewModel {
    protected LoginRepository loginRepository;
    private MutableLiveData<LoginResponse> loginResponseMutable;
    private MutableLiveData<OtherVerticalsResponse> otherVerticalsResponseMutableLiveData;
    private MutableLiveData<DealerLoginResponse> dealerLoginResponseMutableLiveData;
    private MutableLiveData<TenureResponse> tenureResponseMutableLiveData;
    private MutableLiveData<ViewCustomerListResponse> viewCustomerListResponseMutableLiveData;
    private MutableLiveData<AddCustomerResponse> addCustomerResponseMutableLiveData;
    private MutableLiveData<AddCustDocumentResponse> addCustDocumentResponseMutableLiveData;
    private MutableLiveData<CustIDCreationResponse> custIDCreationResponseMutableLiveData;
    private MutableLiveData<DealerIDCreationResponse> dealerIDCreationResponseMutableLiveData;
    private MutableLiveData<AddDealerResponse> addDealerResponseMutableLiveData;
    private MutableLiveData<StateResponse> stateResponseMutableLiveData;
    private MutableLiveData<DistrictResponse> districtResponseMutableLiveData;
    private MutableLiveData<AddCustDocumentResponse> addDealerDocumentResponseMutableLiveData;
    private MutableLiveData<ViewDealerListResponse> viewDealerListResponseMutableLiveData;
    private MutableLiveData<PostOfficeResponse> postOfficeResponseMutableLiveData;
    private MutableLiveData<IndividualCustResponse> individualCustResponseMutableLiveData;
    private MutableLiveData<CibilScoreOutput> cibilResponseMutableLiveData;
    private MutableLiveData<BaseResponse> approveCustomerMutableLiveData;
    private MutableLiveData<BaseResponse> rejectCustomerMutableLiveData;
    private MutableLiveData<DocViewResponse> docViewResponseMutableLiveData;
    private MutableLiveData<QuestionnaireResponse> questionnaireResponseMutableLiveData;
    private MutableLiveData<IndividualDealerResponsse> individualDealerResponsseMutableLiveData;
    private MutableLiveData<BaseResponse> baseResponseMutableLiveData;
    private MutableLiveData<MisReportResponse> misReportResponseMutableLiveData;


    public LoginViewModel() {
        loginRepository = new LoginRepository();
        loginResponseMutable = new MutableLiveData<>();
        otherVerticalsResponseMutableLiveData = new MutableLiveData<>();
        dealerLoginResponseMutableLiveData = new MutableLiveData<>();
        tenureResponseMutableLiveData = new MutableLiveData<>();
        viewCustomerListResponseMutableLiveData = new MutableLiveData<>();
        addCustomerResponseMutableLiveData = new MutableLiveData<>();
        addCustDocumentResponseMutableLiveData = new MutableLiveData<>();
        addDealerResponseMutableLiveData = new MutableLiveData<>();
        stateResponseMutableLiveData = new MutableLiveData<>();
        districtResponseMutableLiveData = new MutableLiveData<>();
        addDealerDocumentResponseMutableLiveData = new MutableLiveData<>();
        viewDealerListResponseMutableLiveData = new MutableLiveData<>();
        postOfficeResponseMutableLiveData = new MutableLiveData<>();
        individualCustResponseMutableLiveData = new MutableLiveData<>();
        cibilResponseMutableLiveData = new MutableLiveData<>();
        custIDCreationResponseMutableLiveData = new MutableLiveData<>();
        dealerIDCreationResponseMutableLiveData = new MutableLiveData<>();
        approveCustomerMutableLiveData = new MutableLiveData<>();
        rejectCustomerMutableLiveData = new MutableLiveData<>();
        docViewResponseMutableLiveData = new MutableLiveData<>();
        questionnaireResponseMutableLiveData = new MutableLiveData<>();
        individualDealerResponsseMutableLiveData = new MutableLiveData<>();
        baseResponseMutableLiveData = new MutableLiveData<>();
        misReportResponseMutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<MisReportResponse> getMisReportResponseMutableLiveData() {
        return misReportResponseMutableLiveData;
    }

    public void setMisReportResponseMutableLiveData(MutableLiveData<MisReportResponse> misReportResponseMutableLiveData) {
        this.misReportResponseMutableLiveData = misReportResponseMutableLiveData;
    }

    public MutableLiveData<BaseResponse> getBaseResponseMutableLiveData() {
        return baseResponseMutableLiveData;
    }

    public void setBaseResponseMutableLiveData(MutableLiveData<BaseResponse> baseResponseMutableLiveData) {
        this.baseResponseMutableLiveData = baseResponseMutableLiveData;
    }

    public MutableLiveData<IndividualDealerResponsse> getIndividualDealerResponsseMutableLiveData() {
        return individualDealerResponsseMutableLiveData;
    }

    public void setIndividualDealerResponsseMutableLiveData(MutableLiveData<IndividualDealerResponsse> individualDealerResponsseMutableLiveData) {
        this.individualDealerResponsseMutableLiveData = individualDealerResponsseMutableLiveData;
    }

    public MutableLiveData<DocViewResponse> getDocViewResponseMutableLiveData() {
        return docViewResponseMutableLiveData;
    }

    public void setDocViewResponseMutableLiveData(MutableLiveData<DocViewResponse> docViewResponseMutableLiveData) {
        this.docViewResponseMutableLiveData = docViewResponseMutableLiveData;


    }

    public MutableLiveData<QuestionnaireResponse> getQuestionnaireResponseMutableLiveData() {
        return questionnaireResponseMutableLiveData;
    }

    public void setQuestionnaireResponseMutableLiveData(MutableLiveData<QuestionnaireResponse> questionnaireResponseMutableLiveData) {
        this.questionnaireResponseMutableLiveData = questionnaireResponseMutableLiveData;
    }

    public MutableLiveData<BaseResponse> getApproveCustomerMutableLiveData() {
        return approveCustomerMutableLiveData;
    }

    public void setApproveCustomerMutableLiveData(MutableLiveData<BaseResponse> approveCustomerMutableLiveData) {
        this.approveCustomerMutableLiveData = approveCustomerMutableLiveData;
    }

    public MutableLiveData<BaseResponse> getRejectCustomerMutableLiveData() {
        return rejectCustomerMutableLiveData;
    }

    public void setRejectCustomerMutableLiveData(MutableLiveData<BaseResponse> rejectCustomerMutableLiveData) {
        this.rejectCustomerMutableLiveData = rejectCustomerMutableLiveData;
    }

    public MutableLiveData<DealerIDCreationResponse> getDealerIDCreationResponseMutableLiveData() {
        return dealerIDCreationResponseMutableLiveData;
    }

    public void setDealerIDCreationResponseMutableLiveData(MutableLiveData<DealerIDCreationResponse> dealerIDCreationResponseMutableLiveData) {
        this.dealerIDCreationResponseMutableLiveData = dealerIDCreationResponseMutableLiveData;
    }

    public MutableLiveData<CustIDCreationResponse> getCustIDCreationResponseMutableLiveData() {
        return custIDCreationResponseMutableLiveData;
    }

    public void setCustIDCreationResponseMutableLiveData(MutableLiveData<CustIDCreationResponse> custIDCreationResponseMutableLiveData) {
        this.custIDCreationResponseMutableLiveData = custIDCreationResponseMutableLiveData;
    }

    public MutableLiveData<CibilScoreOutput> getCibilResponseMutableLiveData() {
        return cibilResponseMutableLiveData;
    }

    public void setCibilResponseMutableLiveData(MutableLiveData<CibilScoreOutput> cibilResponseMutableLiveData) {
        this.cibilResponseMutableLiveData = cibilResponseMutableLiveData;
    }

    public MutableLiveData<IndividualCustResponse> getIndividualCustResponseMutableLiveData() {
        return individualCustResponseMutableLiveData;
    }

    public void setIndividualCustResponseMutableLiveData(MutableLiveData<IndividualCustResponse> individualCustResponseMutableLiveData) {
        this.individualCustResponseMutableLiveData = individualCustResponseMutableLiveData;
    }

    public MutableLiveData<PostOfficeResponse> getPostOfficeResponseMutableLiveData() {
        return postOfficeResponseMutableLiveData;
    }

    public void setPostOfficeResponseMutableLiveData(MutableLiveData<PostOfficeResponse> postOfficeResponseMutableLiveData) {
        this.postOfficeResponseMutableLiveData = postOfficeResponseMutableLiveData;
    }

    public MutableLiveData<ViewDealerListResponse> getViewDealerListResponseMutableLiveData() {
        return viewDealerListResponseMutableLiveData;
    }

    public void setViewDealerListResponseMutableLiveData(MutableLiveData<ViewDealerListResponse> viewDealerListResponseMutableLiveData) {
        this.viewDealerListResponseMutableLiveData = viewDealerListResponseMutableLiveData;
    }

    public MutableLiveData<AddCustDocumentResponse> getAddDealerDocumentResponseMutableLiveData() {
        return addDealerDocumentResponseMutableLiveData;
    }

    public void setAddDealerDocumentResponseMutableLiveData(MutableLiveData<AddCustDocumentResponse> addDealerDocumentResponseMutableLiveData) {
        this.addDealerDocumentResponseMutableLiveData = addDealerDocumentResponseMutableLiveData;
    }

    public MutableLiveData<DistrictResponse> getDistrictResponseMutableLiveData() {
        return districtResponseMutableLiveData;
    }

    public void setDistrictResponseMutableLiveData(MutableLiveData<DistrictResponse> districtResponseMutableLiveData) {
        this.districtResponseMutableLiveData = districtResponseMutableLiveData;
    }

    public MutableLiveData<StateResponse> getStateResponseMutableLiveData() {
        return stateResponseMutableLiveData;
    }

    public void setStateResponseMutableLiveData(MutableLiveData<StateResponse> stateResponseMutableLiveData) {
        this.stateResponseMutableLiveData = stateResponseMutableLiveData;
    }

    public MutableLiveData<AddDealerResponse> getAddDealerResponseMutableLiveData() {
        return addDealerResponseMutableLiveData;
    }

    public void setAddDealerResponseMutableLiveData(MutableLiveData<AddDealerResponse> addDealerResponseMutableLiveData) {
        this.addDealerResponseMutableLiveData = addDealerResponseMutableLiveData;
    }

    public MutableLiveData<AddCustDocumentResponse> getAddCustDocumentResponseMutableLiveData() {
        return addCustDocumentResponseMutableLiveData;
    }

    public void setAddCustDocumentResponseMutableLiveData(MutableLiveData<AddCustDocumentResponse> addCustDocumentResponseMutableLiveData) {
        this.addCustDocumentResponseMutableLiveData = addCustDocumentResponseMutableLiveData;
    }

    public MutableLiveData<AddCustomerResponse> getAddCustomerResponseMutableLiveData() {
        return addCustomerResponseMutableLiveData;
    }

    public void setAddCustomerResponseMutableLiveData(MutableLiveData<AddCustomerResponse> addCustomerResponseMutableLiveData) {
        this.addCustomerResponseMutableLiveData = addCustomerResponseMutableLiveData;
    }

    public MutableLiveData<ViewCustomerListResponse> getViewCustomerListResponseMutableLiveData() {
        return viewCustomerListResponseMutableLiveData;
    }

    public void setViewCustomerListResponseMutableLiveData(MutableLiveData<ViewCustomerListResponse> viewCustomerListResponseMutableLiveData) {
        this.viewCustomerListResponseMutableLiveData = viewCustomerListResponseMutableLiveData;
    }

    public MutableLiveData<TenureResponse> getTenureResponseMutableLiveData() {
        return tenureResponseMutableLiveData;
    }

    public void setTenureResponseMutableLiveData(MutableLiveData<TenureResponse> tenureResponseMutableLiveData) {
        this.tenureResponseMutableLiveData = tenureResponseMutableLiveData;
    }

    public MutableLiveData<DealerLoginResponse> getDealerLoginResponseMutableLiveData() {
        return dealerLoginResponseMutableLiveData;
    }

    public void setDealerLoginResponseMutableLiveData(MutableLiveData<DealerLoginResponse> dealerLoginResponseMutableLiveData) {
        this.dealerLoginResponseMutableLiveData = dealerLoginResponseMutableLiveData;
    }

    public LoginRepository getLoginRepository() {
        return loginRepository;
    }

    public void setLoginRepository(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public MutableLiveData<LoginResponse> getLoginResponseMutable() {
        return loginResponseMutable;
    }

    public void setLoginResponseMutable(MutableLiveData<LoginResponse> loginResponseMutable) {
        this.loginResponseMutable = loginResponseMutable;
    }

    public void login(LoginRequest loginRequest) {
       // LoginRequest request = new LoginRequest(loginRequest.getEmpCode(), loginRequest.getPwd());
        loginRepository.loginUser(loginRequest,
                (LoginRepository.SuccessResponse<LoginResponse>) loginResponse -> {
                    loginResponseMutable.setValue(loginResponse);
                });
    }


    // Dilsha 30-March Get list of all Verticals

    public void getVerticalsList(OtherVerticalsRequest ovRequest) {
        loginRepository.getVerticals(ovRequest,
                (LoginRepository.SuccessResponse<OtherVerticalsResponse>) ovResponse -> {
                    otherVerticalsResponseMutableLiveData.setValue(ovResponse);
                });
    }

    public MutableLiveData<OtherVerticalsResponse> getOtherVerticalsResponseMutableLiveData() {
        return otherVerticalsResponseMutableLiveData;
    }

    public void setOtherVerticalsResponseMutableLiveData(MutableLiveData<OtherVerticalsResponse> otherVerticalsResponseMutableLiveData) {
        this.otherVerticalsResponseMutableLiveData = otherVerticalsResponseMutableLiveData;
    }

    // Dilsha 04-April Dealer Login
    public void dealerLogin(DealerLoginRequest loginRequest) {
        loginRepository.getDealerLogin(loginRequest,
                (LoginRepository.SuccessResponse<DealerLoginResponse>) dealerLoginResponse -> {
                    dealerLoginResponseMutableLiveData.setValue(dealerLoginResponse);
                });
    }

    // Dilsha 15-04-2021 Get tenure details

    public void getTenureList(OtherVerticalsRequest ovRequest) {
        loginRepository.getTenure(ovRequest,
                (LoginRepository.SuccessResponse<TenureResponse>) tenureResponse -> {
                    tenureResponseMutableLiveData.setValue(tenureResponse);
                });
    }

// Dilsha 17-04-2021 Get tenure details

    public void getCustomerList(OtherVerticalsRequest ovRequest) {
        loginRepository.getCustomerList(ovRequest,
                (LoginRepository.SuccessResponse<ViewCustomerListResponse>) viewCustResponse -> {
                    viewCustomerListResponseMutableLiveData.setValue(viewCustResponse);
                });
    }

    // Dilsha 23-06-2021 Get the list of customers to be Approved

    public void getCustomerApproval(OtherVerticalsRequest ovRequest) {
        loginRepository.getToApproveCustomers(ovRequest,
                (LoginRepository.SuccessResponse<ViewCustomerListResponse>) viewCustResponse -> {
                    viewCustomerListResponseMutableLiveData.setValue(viewCustResponse);
                });
    }

// Dilsha 19-04-2021 Add Customer

    public void addCustomer(AddCustomerRequest request) {
        loginRepository.addCustomer(request,
                (LoginRepository.SuccessResponse<AddCustomerResponse>) addCustomerResponse -> {
                    addCustomerResponseMutableLiveData.setValue(addCustomerResponse);
                });
    }

    // Dilsha 27-04 Add customer documents

    public void addCustDocuments(AddCustDocumentRequest request) {
        loginRepository.addCustDocuments(request,
                (LoginRepository.SuccessResponse<AddCustDocumentResponse>) addCustomerDocResponse -> {
                    addCustDocumentResponseMutableLiveData.setValue(addCustomerDocResponse);
                });
    }

    // Dilsha 22-06 Cust id creation

    public void generateCustID(CustIDCreationRequest request) {
        loginRepository.createCustID(request,
                (LoginRepository.SuccessResponse<CustIDCreationResponse>) custIDResponse -> {
                    custIDCreationResponseMutableLiveData.setValue(custIDResponse);
                });
    }

    // Dilsha 07-05-2021 Add Dealer

    public void addDealer(AddDealerRequest request) {
        loginRepository.addDealer(request,
                (LoginRepository.SuccessResponse<AddDealerResponse>) addDealerResponse -> {
                    addDealerResponseMutableLiveData.setValue(addDealerResponse);
                });
    }

    // Dilsha 23-06 Dealer id creation

    public void generateDealerID(DealerIDCreationRequest request) {
        loginRepository.createDealerID(request,
                (LoginRepository.SuccessResponse<DealerIDCreationResponse>) dealerIDResponse -> {
                    dealerIDCreationResponseMutableLiveData.setValue(dealerIDResponse);
                });
    }


    // Dilsha 07-05-2021 get the list of All states

    public void getState(BaseRequest request) {
        loginRepository.getState(request,
                (LoginRepository.SuccessResponse<StateResponse>) getStateResponse -> {
                    stateResponseMutableLiveData.setValue(getStateResponse);
                });
    }

    // Dilsha 08-05-2021 get the list of All districts

    public void getDistrict(DistrictRequest request) {
        loginRepository.getDistrict(request,
                (LoginRepository.SuccessResponse<DistrictResponse>) getDistrictResponse -> {
                    districtResponseMutableLiveData.setValue(getDistrictResponse);
                });
    }

    // Dilsha 18-05 Add dealer documents documents

    public void addDealerDocuments(AddDealerDocumentRequest request) {
        loginRepository.addDealerDocuments(request,
                (LoginRepository.SuccessResponse<AddCustDocumentResponse>) addDealerDocResponse -> {
                    addDealerDocumentResponseMutableLiveData.setValue(addDealerDocResponse);
                });
    }

    // Dilsha 18-05-2021 Get deleae list

    public void getDealerList(ViewDealerListRequest ovRequest) {
        loginRepository.getDealerList(ovRequest,
                (LoginRepository.SuccessResponse<ViewDealerListResponse>) viewDealerListResponse -> {

                    viewDealerListResponseMutableLiveData.setValue(viewDealerListResponse);
                });
    }

    // Dilsha 19-05-2021 get the list of All states from pincode

    public void getStateFromPin(StateFromPinRequest request) {
        loginRepository.getStateFromPin(request,
                (LoginRepository.SuccessResponse<StateResponse>) getStateResponse -> {
                    stateResponseMutableLiveData.setValue(getStateResponse);
                });
    }
    // Dilsha 22-05-2021 sessionout from

    public void sessionOut(BaseRequest request) {
        loginRepository.sessionLogout(request,
                (LoginRepository.SuccessResponse<OtherVerticalsResponse>) logoutResponse -> {
                    otherVerticalsResponseMutableLiveData.setValue(logoutResponse);
                });
    }

    // Dilsha 24-05-2021 get the list of All states from pincode

    public void getPostOffice(StateFromPinRequest request) {
        loginRepository.getPostOffice(request,
                (LoginRepository.SuccessResponse<PostOfficeResponse>) getPOResponse -> {
                    postOfficeResponseMutableLiveData.setValue(getPOResponse);
                });
    }

    // Dilsha 26-05-2021 get details of Individual customer

    public void getIndividualCust(OtherVerticalsRequest request) {
        loginRepository.getIndividualCustomer(request,
                (LoginRepository.SuccessResponse<IndividualCustResponse>) indiCustResponse -> {
                    individualCustResponseMutableLiveData.setValue(indiCustResponse);
                });
    }

    // Dilsha 02-07-2021 get details of Individual Dealer

    public void getIndividualDealer(OtherVerticalsRequest request) {
        loginRepository.getIndividualDealer(request,
                (LoginRepository.SuccessResponse<IndividualDealerResponsse>) indiDealerResponse -> {
                    individualDealerResponsseMutableLiveData.setValue(indiDealerResponse);
                });
    }

    // Dilsha 28-06-2021 Approve Customer

    public void approveCDLCustomer(OtherVerticalsRequest request) {
        loginRepository.approveCDLCustomer(request,
                (LoginRepository.SuccessResponse<BaseResponse>) approveResponse -> {
                    approveCustomerMutableLiveData.setValue(approveResponse);
                });
    }

    // Dilsha 28-06-2021 Reject Customer

    public void rejectCDLCustomer(RejectCustomerRequest request) {
        loginRepository.rejectCDLCustomer(request,
                (LoginRepository.SuccessResponse<BaseResponse>) rejectResponse -> {
                    rejectCustomerMutableLiveData.setValue(rejectResponse);
                });
    }

    // Dilsha 29-06-2021  Customer documents

    public void viewCustomerDoc(DocViewRequest request) {
        loginRepository.viewCustomerDocument(request,
                (LoginRepository.SuccessResponse<DocViewResponse>) docViewResponse -> {
                    docViewResponseMutableLiveData.setValue(docViewResponse);
                });
    }

    // Dilsha 02-07-2021  Dealer documents

    public void viewDealerDoc(DocViewRequest request) {
        loginRepository.viewDealerDocument(request,
                (LoginRepository.SuccessResponse<DocViewResponse>) docViewResponse -> {
                    docViewResponseMutableLiveData.setValue(docViewResponse);
                });
    }

    // Dilsha 29-06-2021 Edit Customer details

    public void editCustomerDetails(EditCustomerRequest request) {
        loginRepository.editCustomerDetails(request,
                (LoginRepository.SuccessResponse<AddCustomerResponse>) editCustResponse -> {
                    addCustomerResponseMutableLiveData.setValue(editCustResponse);
                });
    }


    public void getCIBILScore(CIBILRequest request) {
        loginRepository.getCIBILScore(request,
                (LoginRepository.SuccessResponse<CibilScoreOutput>) cibilResponse -> {
                    cibilResponseMutableLiveData.setValue(cibilResponse);
                });
    }

    // Sooraj 11-06-2021 get questionnaire list

    public void getQuestionnaire(BaseRequest request) {
        loginRepository.getQuestionnaireList(request,
                (LoginRepository.SuccessResponse<QuestionnaireResponse>) questionnaireResponse -> {
                    questionnaireResponseMutableLiveData.setValue(questionnaireResponse);
                });
    }

    // Sooraj 03-07-2021 send Internal score value

    public void sendInternalScore(ScoreCardRequest request) {

        loginRepository.sendInternalScore(request,
                (LoginRepository.SuccessResponse<BaseResponse>) scoreCardResponse -> {
                    baseResponseMutableLiveData.setValue(scoreCardResponse);
                });
    }

    // Dilsha 05-10-2021 MIS Report dashboard
    public void viewMISData(OtherVerticalsRequest request) {

        loginRepository.getMISData(request,
                (LoginRepository.SuccessResponse<MisReportResponse>) misReportResponse -> {
                    misReportResponseMutableLiveData.setValue(misReportResponse);
                });
    }
}

