package com.manappuram.twowheeler;

import com.manappuram.twowheeler.request.cibilinput.CibilScoreInput;
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

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIInterface {
    @POST("AndroidgettwlEmpDetails")
    @FormUrlEncoded
    Call<LoginResponse> Androidlogin(@Field("empCode") String empCode,
                                     @Field("pwd") String pwd);

    // get CDL products
    @POST("GettwlProducts")
    @FormUrlEncoded
    Call<OtherVerticalsResponse> getVerticals(@Field("flag") String flag,
                                              @Field("sessionId") String sessionId);

    @POST("AndroidgettwldealerDetails")
    @FormUrlEncoded
    Call<DealerLoginResponse> getDealerLogin(@Field("dealerCode") String dealerCode,
                                             @Field("pwd") String pwd);

    @POST("Gettwltenure")
    @FormUrlEncoded
    Call<TenureResponse> getTenure(@Field("flag") String flag,
                                   @Field("sessionId") String sessionId);

    @POST("viewTWLcustomer")
    @FormUrlEncoded
    Call<ViewCustomerListResponse> getCustomerList(@Field("flag") String flag,
                                                   @Field("empcode") String empcode,
                                                   @Field("sessionId") String sessionId);



    @POST("TWLcustomerinsert")
    @FormUrlEncoded
    Call<AddCustomerResponse> addNewCustomer(@Field("flag") String flag,
                                             @Field("cust_name") String cust_name,
                                             @Field("gender") String gender,
                                             @Field("dob") String dob,
                                             @Field("address") String address,
                                             @Field("pincode") String pincode,
                                             @Field("state") String state,
                                             @Field("district") String district,
                                             @Field("profession") String profession,
                                             @Field("product_name") String product_name,
                                             @Field("quotation") String quotation,
                                             @Field("tenure") String tenure,
                                             @Field("mob") String mob,
                                             @Field("emi_status") String emi_status,
                                             @Field("uploaded_by") String uploaded_by,
                                             //new
                                             @Field("loc") String loc,
                                             @Field("h_name") String h_name,
                                             @Field("job_typ") String job_typ,
                                             @Field("dist_id") String dist_id,
                                             @Field("stat_id") String stat_id,
                                             @Field("post") String post,
                                             @Field("Branchid") String Branchid, // June 22
                                             @Field("cibil_score") String cibil_score,// June 28
                                             @Field("Loan_amt") String loan_amount,//July 07
                                             @Field("sessionId") String sessionId);

    @POST("TWLcustDOCSInsert")
    @FormUrlEncoded
    Call<AddCustDocumentResponse> addCustomerDocuments(@Field("cust_name") String cust_name,
                                                       @Field("doc_seq") String doc_seq, // Jun 22
                                                       @Field("Questioncopy") String Questioncopy,
                                                       @Field("pan_no") String pan_no,
                                                       @Field("PanCopy") String PanCopy,
                                                       @Field("bankstatement") String bankstatement,
                                                       @Field("status") String status,
                                                       @Field("upload_by") String upload_by,
                                                       @Field("cust_mob") String cust_mob, // Jun 22
                                                       @Field("sessionId") String sessionId);

    @POST("TWL_DEALERinsert")
    @FormUrlEncoded
    Call<AddDealerResponse> addNewDealer(@Field("flag") String flag,
                                         @Field("shop_name") String shop_name,
                                         @Field("owner_name") String owner_name,
                                         @Field("shop_gst") String shop_gst,
                                         @Field("pan_no") String pan_no,
                                         @Field("id_no") String id_no,
                                         @Field("id_type") String id_type,
                                         @Field("loc_name") String loc_name,
                                         @Field("post_office") String post_office,
                                         @Field("district") String district,
                                         @Field("state") String state,
                                         @Field("pin") String pin,
                                         @Field("mob") String mob,
                                         @Field("email") String email,
                                         @Field("upload_by") String upload_by,
                                         @Field("sessionId") String sessionId);

    // get State
    @POST("GetTWLStates")
    @FormUrlEncoded
    Call<StateResponse> getState(@Field("flag") String flag,
                                 @Field("sessionId") String sessionId);

    // get District
    @POST("GetTWLDistricts")
    @FormUrlEncoded
    Call<DistrictResponse> getDistrict(@Field("flag") String flag,
                                       @Field("state_id") String state_id,
                                       @Field("sessionId") String sessionId);

    @POST("TWLDEALERDOCSInsert")
    @FormUrlEncoded
    Call<AddCustDocumentResponse> addDealerDocuments(@Field("dealer") String dealer,
                                                     @Field("doc_seq") String doc_seq,
                                                     @Field("Questioncopy") String Questioncopy,
                                                     @Field("pan_card") String pan_card,
                                                     @Field("aadhar") String aadhar,
                                                     @Field("bank_statement") String bank_statement,
                                                     @Field("pledge_form") String pledge_form,
                                                     @Field("agreement") String agreement,
                                                     @Field("gold_backed") String gold_backed,
                                                     @Field("upload_by") String upload_by,
                                                     @Field("deal_mob") String deal_mob,
                                                     @Field("status") String status,
                                                     @Field("sessionId") String sessionId);

    // June 23
    @POST("TWL_Dealerid")
    @FormUrlEncoded
    Call<DealerIDCreationResponse> dealerIDCreation(@Field("flag") String flag,
                                                    @Field("id_no") String id_no,
                                                    @Field("mob") String mob,
                                                    @Field("doc_seq") String doc_seq,
                                                    @Field("sessionId") String sessionId);

    @POST("viewTWLdealer")
    @FormUrlEncoded
    Call<ViewDealerListResponse> getDealerList(@Field("flag") String flag,
                                               @Field("emp_code") String emp_code,
                                               @Field("sessionId") String sessionId);

    @POST("Pincode_States")
    @FormUrlEncoded
    Call<StateResponse> getStateFromPin(@Field("flag") String flag,
                                        @Field("pin") String pin,
                                        @Field("sessionId") String sessionId);

    @POST("TWLsessionLogout")
    @FormUrlEncoded
    Call<OtherVerticalsResponse> sessionLogout(@Field("sessionId") String sessionId);

    @POST("TWL_postoffice")
    @FormUrlEncoded
    Call<PostOfficeResponse> getPostOffice(@Field("flag") String flag,
                                           @Field("pin") String pin,
                                           @Field("sessionId") String sessionId);

    @POST("GetTWLcustomer") // Individual cust id details
    @FormUrlEncoded
    Call<IndividualCustResponse> getIndividualCustomer(@Field("flag") String flag,
                                                       @Field("cust_id") String cust_id,
                                                       @Field("sessionId") String sessionId);

    @POST("GetTWLdealer") // Individual dealer id details
    @FormUrlEncoded
    Call<IndividualDealerResponsse> getIndividualDealer(@Field("flag") String flag,
                                                        @Field("dealer_id") String dealer_id,
                                                        @Field("sessionId") String sessionId);

    // June 22
    @POST("TWL_Customerid")
    @FormUrlEncoded
    Call<CustIDCreationResponse> custIDCreation(@Field("flag") String flag,
                                                @Field("cust_name") String cust_name,
                                                @Field("cust_mob") String cust_mob,
                                                @Field("doc_seq") String doc_seq,
                                                @Field("state_id") String state_id,
                                                @Field("district_id") String district_id,
                                                @Field("loan_amt") String loan_amt,
                                                @Field("profession") String profession,
                                                @Field("updated_by") String updated_by,
                                                @Field("branch_id") String branch_id,
                                                @Field("dob") String dob,
                                                @Field("sessionId") String sessionId);

    // June 23 Get the list of Customers to be Approved by National Head
    @POST("GetTWL_custForApproval")
    @FormUrlEncoded
    Call<ViewCustomerListResponse> getCustomerApprovalList(@Field("flag") String flag,
                                                           @Field("emp_no") String emp_no,
                                                           @Field("sessionId") String sessionId);

    // June 28 Credit Head Approval
    @POST("TWL_customer_Approval")
    @FormUrlEncoded
    Call<BaseResponse> approveCDLCustomer(@Field("flag") String flag,
                                          @Field("cust_id") String cust_id,
                                          @Field("sessionId") String sessionId);

    // June 28 Credit Head Rejection
    @POST("TWL_customer_Reject")
    @FormUrlEncoded
    Call<BaseResponse> rejectCDLCustomer(@Field("flag") String flag,
                                         @Field("cust_id") String cust_id,
                                         @Field("remarks") String remarks,
                                         @Field("sessionId") String sessionId);

    // June 29 Cust doc id view
    @POST("DOC_TWLCUSTVIEW")
    @FormUrlEncoded
    Call<DocViewResponse> viewCustomerDocs(@Field("flag") String flag,
                                           @Field("cust_id") String cust_id,
                                           @Field("doc_name") String doc_name,
                                           @Field("sessionId") String sessionId);

    // July 02 Dealer doc id view
    @POST("DOC_TWLDEALERVIEW")
    @FormUrlEncoded
    Call<DocViewResponse> viewDealerDocs(@Field("flag") String flag,
                                           @Field("dealer_id") String cust_id,
                                           @Field("doc_name") String doc_name,
                                           @Field("sessionId") String sessionId);

    // June 29 edit customer details
    @POST("Edit_twlcustomer")
    @FormUrlEncoded
    Call<AddCustomerResponse> editCustomerDetails(@Field("flag") String flag,
                                                  @Field("cust_id") String cust_id,
                                                  @Field("cust_name") String cust_name,
                                                  @Field("dob") String dob,
                                                  @Field("address") String address,
                                                  @Field("pincode") String pincode,
                                                  @Field("profession") String profession,
                                                  @Field("mob") String mob,
                                                  @Field("sessionId") String sessionId);


    //////////////////////////////// CIBIL MAcom API//////////////////////////////////////////

    @POST("GetScoreAndHTMLBase64")
    @FormUrlEncoded
    Call<CibilScoreOutput> getCIBILScore(@Field("applicantType") String applicantType,
                                         @Field("applicantFirstName") String applicantFirstName,
                                         @Field("applicantLastName") String applicantLastName,
                                         @Field("dateOfBirth") String dateOfBirth,
                                         @Field("gender") String gender,
                                         @Field("idNumber") String idNumber,
                                         @Field("idType") String idType,
                                         @Field("telephoneNumber") String telephoneNumber,
                                         @Field("telephoneType") String telephoneType,
                                         @Field("addressLine1") String addressLine1,
                                         @Field("addressLine2") String addressLine2,
                                         @Field("addressLine3") String addressLine3,
                                         @Field("city") String city,
                                         @Field("pinCode") String pinCode,
                                         @Field("residenceType") String residenceType,
                                         @Field("stateCode") String stateCode,
                                         @Field("purpose") String purpose,
                                         @Field("amount") String amount,
                                         @Field("scoreType") String scoreType,
                                         @Field("gstStateCode") String gstStateCode,
                                         @Field("cibilBureauFlag") String cibilBureauFlag,
                                         @Field("idVerificationFlag") String idVerificationFlag
    );

    @POST("GetScoreAndHTMLBase64")
    Call<CibilScoreOutput> getScore(@Body CibilScoreInput getScoreInput);

    @POST("GetQuestionnaire")
    @FormUrlEncoded
    Call<QuestionnaireResponse> getQuestionnaire(@Field("sessionId") String sessionId);

    // Dilsha 03 July 2021 send Internal score to DB
    @POST("TWL_questionnairescore")
    @FormUrlEncoded
    Call<BaseResponse> sendInternalScore(@Field("flag") String flag,
                                         @Field("cust_id") String cust_id,
                                         @Field("scorestring") String scorestring ,
                                         @Field("total") String total,
                                         @Field("sessionId") String sessionId
    );

    // MIS Report Dashboard 05 Oct 2021
    @POST("GetTWLMISReport")
    @FormUrlEncoded
    Call<MisReportResponse> getMISReport(@Field("flag") String flag,
                                         @Field("sessionId") String sessionId);
}
