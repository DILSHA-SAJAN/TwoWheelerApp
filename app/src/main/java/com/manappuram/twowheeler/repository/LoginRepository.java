package com.manappuram.twowheeler.repository;

import com.manappuram.twowheeler.network.CIBILRetrofitClient;
import com.manappuram.twowheeler.network.RetrofitClient;
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
import com.manappuram.twowheeler.request.RetrofitRequest;
import com.manappuram.twowheeler.request.ScoreCardRequest;
import com.manappuram.twowheeler.request.StateFromPinRequest;
import com.manappuram.twowheeler.request.ViewDealerListRequest;
import com.manappuram.twowheeler.request.cibilinput.AddressInput;
import com.manappuram.twowheeler.request.cibilinput.AddressesInput;
import com.manappuram.twowheeler.request.cibilinput.Applicant;
import com.manappuram.twowheeler.request.cibilinput.Applicants;
import com.manappuram.twowheeler.request.cibilinput.ApplicationData;
import com.manappuram.twowheeler.request.cibilinput.CibilScoreInput;
import com.manappuram.twowheeler.request.cibilinput.Field;
import com.manappuram.twowheeler.request.cibilinput.Fields;
import com.manappuram.twowheeler.request.cibilinput.Identifier;
import com.manappuram.twowheeler.request.cibilinput.Identifiers;
import com.manappuram.twowheeler.request.cibilinput.Telephone;
import com.manappuram.twowheeler.request.cibilinput.Telephones;
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
import com.manappuram.twowheeler.response.OtherVerticalsResponse;
import com.manappuram.twowheeler.response.Output.CibilScoreOutput;
import com.manappuram.twowheeler.response.PostOfficeResponse;
import com.manappuram.twowheeler.response.QuestionnaireResponse;
import com.manappuram.twowheeler.response.ResponseListener;
import com.manappuram.twowheeler.response.StateResponse;
import com.manappuram.twowheeler.response.TenureResponse;
import com.manappuram.twowheeler.response.ViewCustomerListResponse;
import com.manappuram.twowheeler.response.ViewDealerListResponse;
import com.manappuram.twowheeler.utils.Event;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;
import retrofit2.Call;

public class LoginRepository extends BaseRepository {
    public void loginUser(LoginRequest login, SuccessResponse successResponse) {
        Call<LoginResponse> call = RetrofitClient.getAPIInterface().Androidlogin(login.getEmpCode(), login.getPwd());

        new RetrofitRequest<>(call, new ResponseListener<LoginResponse>() {
            @Override
            public void onResponse(LoginResponse response, Headers headers) {
                if (null != successResponse) {
                    successResponse.onResponse(response);
                }
            }

            @Override
            public void onError(int status, BaseResponse errors) {
                errorsMutable.postValue(new Event<>(errors));

            }


            @Override
            public void onFailure(Throwable throwable) {
                failMessageMutable.postValue(new Event<>(throwable.getMessage()));
            }

        }).enqueue();
    }

    public void getVerticals(OtherVerticalsRequest request, SuccessResponse successResponse) {
        Call<OtherVerticalsResponse> call = RetrofitClient.getAPIInterface().getVerticals(request.getFlag(), request.getSessionId());

        new RetrofitRequest<>(call, new ResponseListener<OtherVerticalsResponse>() {

            @Override
            public void onResponse(OtherVerticalsResponse response, Headers headers) {
                if (null != successResponse) {
                    successResponse.onResponse(response);
                }
            }

            @Override
            public void onError(int status, BaseResponse errors) {
                errorsMutable.postValue(new Event<>(errors));
            }

            @Override
            public void onFailure(Throwable throwable) {
                failMessageMutable.postValue(new Event<>(throwable.getMessage()));
            }
        }).enqueue();
    }

    public void getDealerLogin(DealerLoginRequest request, SuccessResponse successResponse) {
        Call<DealerLoginResponse> call = RetrofitClient.getAPIInterface().getDealerLogin(request.getDealerCode(), request.getPwd());

        new RetrofitRequest<>(call, new ResponseListener<DealerLoginResponse>() {


            @Override
            public void onResponse(DealerLoginResponse response, Headers headers) {
                if (null != successResponse) {
                    successResponse.onResponse(response);
                }
            }

            @Override
            public void onError(int status, BaseResponse errors) {
                errorsMutable.postValue(new Event<>(errors));
            }

            @Override
            public void onFailure(Throwable throwable) {
                failMessageMutable.postValue(new Event<>(throwable.getMessage()));
            }
        }).enqueue();
    }

    public void getTenure(OtherVerticalsRequest request, SuccessResponse successResponse) {
        Call<TenureResponse> call = RetrofitClient.getAPIInterface().getTenure(request.getFlag(), request.getSessionId());

        new RetrofitRequest<>(call, new ResponseListener<TenureResponse>() {


            @Override
            public void onResponse(TenureResponse response, Headers headers) {
                if (null != successResponse) {
                    successResponse.onResponse(response);
                }
            }

            @Override
            public void onError(int status, BaseResponse errors) {
                errorsMutable.postValue(new Event<>(errors));
            }

            @Override
            public void onFailure(Throwable throwable) {
                failMessageMutable.postValue(new Event<>(throwable.getMessage()));
            }
        }).enqueue();
    }

    public void getCustomerList(OtherVerticalsRequest request, SuccessResponse successResponse) {
        Call<ViewCustomerListResponse> call = RetrofitClient.getAPIInterface().getCustomerList(request.getFlag(), request.getEmpcode(), request.getSessionId());

        new RetrofitRequest<>(call, new ResponseListener<ViewCustomerListResponse>() {


            @Override
            public void onResponse(ViewCustomerListResponse response, Headers headers) {
                if (null != successResponse) {
                    successResponse.onResponse(response);
                }
            }

            @Override
            public void onError(int status, BaseResponse errors) {
                errorsMutable.postValue(new Event<>(errors));
            }

            @Override
            public void onFailure(Throwable throwable) {
                failMessageMutable.postValue(new Event<>(throwable.getMessage()));
            }
        }).enqueue();
    }

    // June 23 to get the Customers to be approved by Credit Head
    public void getToApproveCustomers(OtherVerticalsRequest request, SuccessResponse successResponse) {
        Call<ViewCustomerListResponse> call = RetrofitClient.getAPIInterface().getCustomerApprovalList(request.getFlag(), request.getEmpcode(), request.getSessionId());

        new RetrofitRequest<>(call, new ResponseListener<ViewCustomerListResponse>() {


            @Override
            public void onResponse(ViewCustomerListResponse response, Headers headers) {
                if (null != successResponse) {
                    successResponse.onResponse(response);
                }
            }

            @Override
            public void onError(int status, BaseResponse errors) {
                errorsMutable.postValue(new Event<>(errors));
            }

            @Override
            public void onFailure(Throwable throwable) {
                failMessageMutable.postValue(new Event<>(throwable.getMessage()));
            }
        }).enqueue();
    }

    public void addCustomer(AddCustomerRequest request, SuccessResponse successResponse) {
        Call<AddCustomerResponse> call = RetrofitClient.getAPIInterface().addNewCustomer(
                request.getFlag(),
                request.getCust_name(),
                request.getGender(),
                request.getDob(),
                request.getAddress(),
                request.getPincode(),
                request.getState(),
                request.getDistrict(),
                request.getProfession(),
                request.getProduct_name(),
                request.getQuotation(),
                request.getTenure(),
                request.getMob(),
                request.getEmi_status(),
                request.getUploaded_by(),
                request.getLoc(),
                request.getH_name(),
                request.getJob_typ(),
                request.getDist_id(),
                request.getStat_id(),
                request.getPost(),
                request.getBranchid(),
                request.getCibil_score(),
                request.getLoan_amount(),
                request.getSessionId());

        new RetrofitRequest<>(call, new ResponseListener<AddCustomerResponse>() {

            @Override
            public void onResponse(AddCustomerResponse response, Headers headers) {
                if (null != successResponse) {
                    successResponse.onResponse(response);
                }
            }

            @Override
            public void onError(int status, BaseResponse errors) {
                errorsMutable.postValue(new Event<>(errors));
            }

            @Override
            public void onFailure(Throwable throwable) {
                failMessageMutable.postValue(new Event<>(throwable.getMessage()));
            }
        }).enqueue();
    }

    // add Customer documents 27 April
    public void addCustDocuments(AddCustDocumentRequest request, SuccessResponse successResponse) {
        Call<AddCustDocumentResponse> call = RetrofitClient.getAPIInterface().addCustomerDocuments(
                request.getCust_name(),
                request.getDoc_seq(),
                request.getQuestioncopy(),
                request.getPan_no(),
                request.getPanCopy(),
                request.getBank_statement(),
                request.getStatus(),
                request.getUpload_by(),
                request.getCust_mob(),
                request.getSessionId());

        new RetrofitRequest<>(call, new ResponseListener<AddCustDocumentResponse>() {


            @Override
            public void onResponse(AddCustDocumentResponse response, Headers headers) {
                if (null != successResponse) {
                    successResponse.onResponse(response);
                }
            }

            @Override
            public void onError(int status, BaseResponse errors) {
                errorsMutable.postValue(new Event<>(errors));
            }

            @Override
            public void onFailure(Throwable throwable) {
                failMessageMutable.postValue(new Event<>(throwable.getMessage()));
            }
        }).enqueue();
    }

    // Customer ID creation June 22
    public void createCustID(CustIDCreationRequest request, SuccessResponse successResponse) {
        Call<CustIDCreationResponse> call = RetrofitClient.getAPIInterface().custIDCreation(
                request.getFlag(),
                request.getCust_name(),
                request.getCust_mob(),
                request.getDoc_seq(),
                request.getSessionId());

        new RetrofitRequest<>(call, new ResponseListener<CustIDCreationResponse>() {


            @Override
            public void onResponse(CustIDCreationResponse response, Headers headers) {
                if (null != successResponse) {
                    successResponse.onResponse(response);
                }
            }

            @Override
            public void onError(int status, BaseResponse errors) {
                errorsMutable.postValue(new Event<>(errors));
            }

            @Override
            public void onFailure(Throwable throwable) {
                failMessageMutable.postValue(new Event<>(throwable.getMessage()));
            }
        }).enqueue();
    }

    // add Dealer
    public void addDealer(AddDealerRequest request, SuccessResponse successResponse) {
        Call<AddDealerResponse> call = RetrofitClient.getAPIInterface().addNewDealer(request.getFlag(),
                request.getShop_name(),
                request.getOwner_name(),
                request.getShop_gst(),
                request.getPan_no(),
                request.getId_no(),
                request.getId_type(),
                request.getLoc_name(),
                request.getPost_office(),
                request.getDistrict(),
                request.getState(),
                request.getPin(),
                request.getMob(),
                request.getEmail(),
                request.getUpload_by(),
                request.getSessionId());

        new RetrofitRequest<>(call, new ResponseListener<AddDealerResponse>() {


            @Override
            public void onResponse(AddDealerResponse response, Headers headers) {
                if (null != successResponse) {
                    successResponse.onResponse(response);
                }
            }

            @Override
            public void onError(int status, BaseResponse errors) {
                errorsMutable.postValue(new Event<>(errors));
            }

            @Override
            public void onFailure(Throwable throwable) {
                failMessageMutable.postValue(new Event<>(throwable.getMessage()));
            }
        }).enqueue();
    }

    // Dealer ID creation June 23
    public void createDealerID(DealerIDCreationRequest request, SuccessResponse successResponse) {
        Call<DealerIDCreationResponse> call = RetrofitClient.getAPIInterface().dealerIDCreation(
                request.getFlag(),
                request.getId_no(),
                request.getMob(),
                request.getDoc_seq(),
                request.getSessionId());

        new RetrofitRequest<>(call, new ResponseListener<DealerIDCreationResponse>() {


            @Override
            public void onResponse(DealerIDCreationResponse response, Headers headers) {
                if (null != successResponse) {
                    successResponse.onResponse(response);
                }
            }

            @Override
            public void onError(int status, BaseResponse errors) {
                errorsMutable.postValue(new Event<>(errors));
            }

            @Override
            public void onFailure(Throwable throwable) {
                failMessageMutable.postValue(new Event<>(throwable.getMessage()));
            }
        }).enqueue();
    }

    //get state
    public void getState(BaseRequest request, SuccessResponse successResponse) {
        Call<StateResponse> call = RetrofitClient.getAPIInterface().getState(request.getFlag(), request.getSessionId());

        new RetrofitRequest<>(call, new ResponseListener<StateResponse>() {


            @Override
            public void onResponse(StateResponse response, Headers headers) {
                if (null != successResponse) {
                    successResponse.onResponse(response);
                }
            }

            @Override
            public void onError(int status, BaseResponse errors) {
                errorsMutable.postValue(new Event<>(errors));
            }

            @Override
            public void onFailure(Throwable throwable) {
                failMessageMutable.postValue(new Event<>(throwable.getMessage()));
            }
        }).enqueue();
    }

    //get district
    public void getDistrict(DistrictRequest request, SuccessResponse successResponse) {
        Call<DistrictResponse> call = RetrofitClient.getAPIInterface().getDistrict(request.getFlag(), request.getState_id(), request.getSessionId());

        new RetrofitRequest<>(call, new ResponseListener<DistrictResponse>() {


            @Override
            public void onResponse(DistrictResponse response, Headers headers) {
                if (null != successResponse) {
                    successResponse.onResponse(response);
                }
            }

            @Override
            public void onError(int status, BaseResponse errors) {
                errorsMutable.postValue(new Event<>(errors));
            }

            @Override
            public void onFailure(Throwable throwable) {
                failMessageMutable.postValue(new Event<>(throwable.getMessage()));
            }
        }).enqueue();
    }

    // add Dealer  documents 18 May
    public void addDealerDocuments(AddDealerDocumentRequest request, SuccessResponse successResponse) {
        Call<AddCustDocumentResponse> call = RetrofitClient.getAPIInterface().addDealerDocuments(
                request.getDealer(),
                request.getDoc_seq(),
                request.getQuestioncopy(),
                request.getPan_card(),
                request.getAadhar(),
                request.getBank_statement(),
                request.getPledge_form(),
                request.getAgreement(),
                request.getGold_backed(),
                request.getUpload_by(),
                request.getDeal_mob(),
                request.getStatus(),
                request.getSessionId());

        new RetrofitRequest<>(call, new ResponseListener<AddCustDocumentResponse>() {


            @Override
            public void onResponse(AddCustDocumentResponse response, Headers headers) {
                if (null != successResponse) {
                    successResponse.onResponse(response);
                }
            }

            @Override
            public void onError(int status, BaseResponse errors) {
                errorsMutable.postValue(new Event<>(errors));
            }

            @Override
            public void onFailure(Throwable throwable) {
                failMessageMutable.postValue(new Event<>(throwable.getMessage()));
            }
        }).enqueue();
    }

    // get Dealer List 18 May
    public void getDealerList(ViewDealerListRequest request, SuccessResponse successResponse) {
        Call<ViewDealerListResponse> call = RetrofitClient.getAPIInterface().getDealerList(
                request.getFlag(),
                request.getEmp_code(),
                request.getSessionId());

        new RetrofitRequest<>(call, new ResponseListener<ViewDealerListResponse>() {


            @Override
            public void onResponse(ViewDealerListResponse response, Headers headers) {
                if (null != successResponse) {
                    successResponse.onResponse(response);
                }
            }

            @Override
            public void onError(int status, BaseResponse errors) {
                errorsMutable.postValue(new Event<>(errors));
            }

            @Override
            public void onFailure(Throwable throwable) {
                failMessageMutable.postValue(new Event<>(throwable.getMessage()));
            }
        }).enqueue();
    }

    // get State from pincode 22 May
    public void getStateFromPin(StateFromPinRequest request, SuccessResponse successResponse) {
        Call<StateResponse> call = RetrofitClient.getAPIInterface().getStateFromPin(
                request.getFlag(),
                request.getPin(),
                request.getSessionId());

        new RetrofitRequest<>(call, new ResponseListener<StateResponse>() {


            @Override
            public void onResponse(StateResponse response, Headers headers) {
                if (null != successResponse) {
                    successResponse.onResponse(response);
                }
            }

            @Override
            public void onError(int status, BaseResponse errors) {
                errorsMutable.postValue(new Event<>(errors));
            }

            @Override
            public void onFailure(Throwable throwable) {
                failMessageMutable.postValue(new Event<>(throwable.getMessage()));
            }
        }).enqueue();
    }

    // logout 22 May
    public void sessionLogout(BaseRequest request, SuccessResponse successResponse) {
        Call<OtherVerticalsResponse> call = RetrofitClient.getAPIInterface().sessionLogout(
                request.getSessionId());

        new RetrofitRequest<>(call, new ResponseListener<OtherVerticalsResponse>() {


            @Override
            public void onResponse(OtherVerticalsResponse response, Headers headers) {
                if (null != successResponse) {
                    successResponse.onResponse(response);
                }
            }

            @Override
            public void onError(int status, BaseResponse errors) {
                errorsMutable.postValue(new Event<>(errors));
            }

            @Override
            public void onFailure(Throwable throwable) {
                failMessageMutable.postValue(new Event<>(throwable.getMessage()));
            }
        }).enqueue();
    }

    // get Post office details 24 May
    public void getPostOffice(StateFromPinRequest request, SuccessResponse successResponse) {
        Call<PostOfficeResponse> call = RetrofitClient.getAPIInterface().getPostOffice(
                request.getFlag(),
                request.getPin(),
                request.getSessionId());

        new RetrofitRequest<>(call, new ResponseListener<PostOfficeResponse>() {


            @Override
            public void onResponse(PostOfficeResponse response, Headers headers) {
                if (null != successResponse) {
                    successResponse.onResponse(response);
                }
            }

            @Override
            public void onError(int status, BaseResponse errors) {
                errorsMutable.postValue(new Event<>(errors));
            }

            @Override
            public void onFailure(Throwable throwable) {
                failMessageMutable.postValue(new Event<>(throwable.getMessage()));
            }
        }).enqueue();
    }

    // get Individual customer details 26 May
    public void getIndividualCustomer(OtherVerticalsRequest request, SuccessResponse successResponse) {
        Call<IndividualCustResponse> call = RetrofitClient.getAPIInterface().getIndividualCustomer(
                request.getFlag(),
                request.getEmpcode(),
                request.getSessionId());

        new RetrofitRequest<>(call, new ResponseListener<IndividualCustResponse>() {


            @Override
            public void onResponse(IndividualCustResponse response, Headers headers) {
                if (null != successResponse) {
                    successResponse.onResponse(response);
                }
            }

            @Override
            public void onError(int status, BaseResponse errors) {
                errorsMutable.postValue(new Event<>(errors));
            }

            @Override
            public void onFailure(Throwable throwable) {
                failMessageMutable.postValue(new Event<>(throwable.getMessage()));
            }
        }).enqueue();
    }

    // get Individual Dealer details 02 July
    public void getIndividualDealer(OtherVerticalsRequest request, SuccessResponse successResponse) {
        Call<IndividualDealerResponsse> call = RetrofitClient.getAPIInterface().getIndividualDealer(
                request.getFlag(),
                request.getEmpcode(),// pass dealer id here
                request.getSessionId());

        new RetrofitRequest<>(call, new ResponseListener<IndividualDealerResponsse>() {


            @Override
            public void onResponse(IndividualDealerResponsse response, Headers headers) {
                if (null != successResponse) {
                    successResponse.onResponse(response);

                }
            }

            @Override
            public void onError(int status, BaseResponse errors) {
                errorsMutable.postValue(new Event<>(errors));

            }

            @Override
            public void onFailure(Throwable throwable) {
                failMessageMutable.postValue(new Event<>(throwable.getMessage()));

            }
        }).enqueue();
    }

    // get Individual customer details 29 June
    public void viewCustomerDocument(DocViewRequest request, SuccessResponse successResponse) {
        Call<DocViewResponse> call = RetrofitClient.getAPIInterface().viewCustomerDocs(
             request.getFlag(),
                request.getEmpcode(),
                request.getDoc_name(),
                request.getSessionId());

        new RetrofitRequest<>(call, new ResponseListener<DocViewResponse>() {
            @Override
            public void onResponse(DocViewResponse response, Headers headers) {
                if (null != successResponse) {
                    successResponse.onResponse(response);
                }
            }

            @Override
            public void onError(int status, BaseResponse errors) {
                errorsMutable.postValue(new Event<>(errors));
            }

            @Override
            public void onFailure(Throwable throwable) {
                failMessageMutable.postValue(new Event<>(throwable.getMessage()));
            }
        }).enqueue();
    }

    // get Individual Dealer details 02 July
    public void viewDealerDocument(DocViewRequest request, SuccessResponse successResponse) {
        Call<DocViewResponse> call = RetrofitClient.getAPIInterface().viewDealerDocs(
                request.getFlag(),
                request.getEmpcode(), // pass dealer id
                request.getDoc_name(),
                request.getSessionId());

        new RetrofitRequest<>(call, new ResponseListener<DocViewResponse>() {
            @Override
            public void onResponse(DocViewResponse response, Headers headers) {
                if (null != successResponse) {
                    successResponse.onResponse(response);
                }
            }

            @Override
            public void onError(int status, BaseResponse errors) {
                errorsMutable.postValue(new Event<>(errors));
            }

            @Override
            public void onFailure(Throwable throwable) {
                failMessageMutable.postValue(new Event<>(throwable.getMessage()));
            }
        }).enqueue();
    }

    // Edi 29 June Edit Customer Details
    public void editCustomerDetails(EditCustomerRequest request, SuccessResponse successResponse) {
        Call<AddCustomerResponse> call = RetrofitClient.getAPIInterface().editCustomerDetails(
                request.getFlag(),
                request.getCust_id(),
                request.getCust_name(),
                request.getDob(),
                request.getAddress(),
                request.getPincode(),
                request.getProfession(),
                request.getMob(),
                request.getSessionId());

        new RetrofitRequest<>(call, new ResponseListener<AddCustomerResponse>() {


            @Override
            public void onResponse(AddCustomerResponse response, Headers headers) {
                if (null != successResponse) {
                    successResponse.onResponse(response);
                }
            }

            @Override
            public void onError(int status, BaseResponse errors) {
                errorsMutable.postValue(new Event<>(errors));
            }

            @Override
            public void onFailure(Throwable throwable) {
                failMessageMutable.postValue(new Event<>(throwable.getMessage()));
            }
        }).enqueue();
    }

    /*******************************National Credit Head**************************************/

    // Approve customer Jun 28
    public void approveCDLCustomer(OtherVerticalsRequest request, SuccessResponse successResponse) {
        Call<BaseResponse> call = RetrofitClient.getAPIInterface().approveCDLCustomer(
                request.getFlag(),
                request.getEmpcode(),
                request.getSessionId());

        new RetrofitRequest<>(call, new ResponseListener<BaseResponse>() {


            @Override
            public void onResponse(BaseResponse response, Headers headers) {
                if (null != successResponse) {
                    successResponse.onResponse(response);
                }
            }

            @Override
            public void onError(int status, BaseResponse errors) {
                errorsMutable.postValue(new Event<>(errors));
            }

            @Override
            public void onFailure(Throwable throwable) {
                failMessageMutable.postValue(new Event<>(throwable.getMessage()));
            }
        }).enqueue();
    }

    // Reject customer Jun 28
    public void rejectCDLCustomer(RejectCustomerRequest request, SuccessResponse successResponse) {
        Call<BaseResponse> call = RetrofitClient.getAPIInterface().rejectCDLCustomer(
                request.getFlag(),
                request.getEmpcode(),
                request.getRemarks(),
                request.getSessionId());

        new RetrofitRequest<>(call, new ResponseListener<BaseResponse>() {


            @Override
            public void onResponse(BaseResponse response, Headers headers) {
                if (null != successResponse) {
                    successResponse.onResponse(response);
                }
            }

            @Override
            public void onError(int status, BaseResponse errors) {
                errorsMutable.postValue(new Event<>(errors));
            }

            @Override
            public void onFailure(Throwable throwable) {
                failMessageMutable.postValue(new Event<>(throwable.getMessage()));
            }
        }).enqueue();
    }
    /*******************************National Credit Head**************************************/

    ////////////////////////////////CIBIL ARea/////////////////////////////////////////////////////////////
    // get CIBIL details 04 June
    public void getCIBILScore(CIBILRequest request, SuccessResponse successResponse) {
        CibilScoreInput getScoreInput = new CibilScoreInput();

        ApplicationData applicationData = new ApplicationData();
        applicationData.setAmount(request.getAmount());
        applicationData.setPurpose(request.getPurpose());
        applicationData.setScoreType(request.getScoreType());
        applicationData.setNtcProductType("");
        applicationData.setConsumerConsentForUIDAIAuthentication("");
        applicationData.setDsTuNtcFlag("");
        applicationData.setGstStateCode(request.getGstStateCode());
        applicationData.setCibilBureauFlag(request.getCibilBureauFlag());
        applicationData.setIdVerificationFlag(request.getIdVerificationFlag());
        applicationData.setMfiBureauFlag("");
        applicationData.setMfiEnquiryAmount("");
        applicationData.setMfiLoanPurpose("");
        applicationData.setMfiCenterReferenceNo("");
        applicationData.setMfiBranchReferenceNo("");
        applicationData.setFormattedReport("");

        Telephone telephone = new Telephone();
        telephone.setTelephoneExtension("");
        telephone.setTelephoneNumber(request.getTelephoneNumber());
        telephone.setTelephoneType(request.getTelephoneType());
        List<Telephone> telephoneslist = new ArrayList<>();
        telephoneslist.add(telephone);
        Telephones telephones = new Telephones();
        telephones.setTelephone(telephoneslist);

        Identifier identifier = new Identifier();
        identifier.setIdNumber(request.getIdNumber());
        identifier.setIdType(request.getIdType());
        List<Identifier> identifierlist = new ArrayList<>();
        identifierlist.add(identifier);
        Identifiers identifiers = new Identifiers();
        identifiers.setIdentifier(identifierlist);

        AddressInput address = new AddressInput();
        address.setAddressLine1(request.getAddressLine1());
        address.setAddressLine2(request.getAddressLine2());
        address.setAddressLine3(request.getAddressLine3());
        address.setAddressLine4("");
        address.setAddressLine5("");
        address.setAddressType("");
        address.setCity(request.getCity());
        address.setPinCode(request.getPinCode());
        address.setResidenceType(request.getResidenceType());
        address.setStateCode(request.getStateCode());
        List<AddressInput> addresslist = new ArrayList<>();
        addresslist.add(address);
        AddressesInput addresses = new AddressesInput();
        addresses.setAddress(addresslist);

        Applicant applicant = new Applicant();
        applicant.setApplicantType(request.getApplicantType());
        applicant.setApplicantFirstName(request.getApplicantFirstName());
        applicant.setApplicantMiddleName("");
        applicant.setApplicantLastName(request.getApplicantLastName());
        applicant.setDateOfBirth(request.getDateOfBirth());
        applicant.setGender(request.getGender());
        applicant.setIdentifiers(identifiers);
        applicant.setTelephones(telephones);
        applicant.setAddresses(addresses);
        applicant.setNomineeRelation("string");
        applicant.setNomineeName("string");
        applicant.setMemberRelationType4("string");
        applicant.setMemberRelationName4("string");
        applicant.setMemberRelationType3("string");
        applicant.setMemberRelationName3("string");
        applicant.setMemberRelationType2("string");
        applicant.setMemberRelationName2("string");
        applicant.setMemberRelationType1("string");
        applicant.setMemberRelationName1("string");
        applicant.setKeyPersonRelation("string");
        applicant.setKeyPersonName("string");
        applicant.setMemberOtherId3("string");
        applicant.setMemberOtherId3Type("string");
        applicant.setMemberOtherId2("string");
        applicant.setMemberOtherId2Type("string");
        applicant.setMemberOtherId1("string");
        applicant.setMemberOtherId1Type("string");
        List<Applicant> applicantlist = new ArrayList<>();
        applicantlist.add(applicant);
        Applicants applicants = new Applicants();
        applicants.setApplicant(applicantlist);


        Fields fields = new Fields();
        Field field = new Field();
        field.setApplicants(applicants);
        field.setApplicationData(applicationData);
        List<Field> fieldlist = new ArrayList<>();
        fieldlist.add(field);
        fields.setField(fieldlist);
        getScoreInput.setFields(fields);

//
//        Call<CibilScoreOutput> call = CIBILRetrofitClient.getAPIInterface().getCIBILScore(
//                request.getApplicantType(),
//                request.getApplicantFirstName(),
//                request.getApplicantLastName(),
//                request.getDateOfBirth(),
//                request.getGender(),
//                request.getIdNumber(),
//                request.getIdType(),
//                request.getTelephoneNumber(),
//                request.getTelephoneType(),
//                request.getAddressLine1(),
//                request.getAddressLine2(),
//                request.getAddressLine3(),
//                request.getCity(),
//                request.getPinCode(),
//                request.getResidenceType(),
//                request.getStateCode(),
//                request.getPurpose(),
//                request.getAmount(),
//                request.getScoreType(),
//                request.getGstStateCode(),
//                request.getCibilBureauFlag(),
//                request.getIdVerificationFlag()
//
//
//        );
        Call<CibilScoreOutput> call = CIBILRetrofitClient.getAPIInterface().getScore(getScoreInput);
        new RetrofitRequest<>(call, new ResponseListener<CibilScoreOutput>() {


            @Override
            public void onResponse(CibilScoreOutput response, Headers headers) {
                if (null != successResponse) {
                    successResponse.onResponse(response);
                }
            }

            @Override
            public void onError(int status, BaseResponse errors) {
                errorsMutable.postValue(new Event<>(errors));
            }

            @Override
            public void onFailure(Throwable throwable) {
                failMessageMutable.postValue(new Event<>(throwable.getMessage()));
            }
        }).enqueue();
    }

    // get questionnaire list 11 June
    public void getQuestionnaireList(BaseRequest request, SuccessResponse successResponse){
        Call<QuestionnaireResponse> call = RetrofitClient.getAPIInterface().getQuestionnaire(
                request.getSessionId());

        new RetrofitRequest<>(call, new ResponseListener<QuestionnaireResponse>() {


            @Override
            public void onResponse(QuestionnaireResponse response, Headers headers) {
                if (null != successResponse) {
                    successResponse.onResponse(response);
                }
            }

            @Override
            public void onError(int status, BaseResponse errors) {
                errorsMutable.postValue(new Event<>(errors));
            }

            @Override
            public void onFailure(Throwable throwable) {
                failMessageMutable.postValue(new Event<>(throwable.getMessage()));
            }
        }).enqueue();
    }

    // send Internal Score 03 July
    public void sendInternalScore(ScoreCardRequest request, SuccessResponse successResponse){
        Call<BaseResponse> call = RetrofitClient.getAPIInterface().sendInternalScore(
                request.getFlag(),
                request.getCustid(),
                request.getScore_string(),
                request.getTotal_score(),
                request.getSessionId());

        new RetrofitRequest<>(call, new ResponseListener<BaseResponse>() {


            @Override
            public void onResponse(BaseResponse response, Headers headers) {
                if (null != successResponse) {
                    successResponse.onResponse(response);
                }
            }

            @Override
            public void onError(int status, BaseResponse errors) {
                errorsMutable.postValue(new Event<>(errors));
            }

            @Override
            public void onFailure(Throwable throwable) {
                failMessageMutable.postValue(new Event<>(throwable.getMessage()));
            }
        }).enqueue();
    }

}
