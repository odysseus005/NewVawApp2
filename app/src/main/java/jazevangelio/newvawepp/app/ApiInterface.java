package jazevangelio.newvawepp.app;




import java.util.List;
import java.util.Map;

import jazevangelio.newvawepp.model.data.Company;
import jazevangelio.newvawepp.model.data.Emergency;
import jazevangelio.newvawepp.model.data.User;
import jazevangelio.newvawepp.model.response.LoginResponse;
import jazevangelio.newvawepp.model.response.ResultResponse;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


public interface ApiInterface {

    @FormUrlEncoded
    @POST(Endpoints.CLIENT)
    Call<LoginResponse> login(@Field(Constants.TAG) String tag,
                              @Field(Constants.EMAIL) String username,
                              @Field(Constants.PASSWORD) String password);


    @FormUrlEncoded
    @POST(Endpoints.CLIENT)
    Call<ResultResponse> register(@Field(Constants.TAG) String tag,
                                  @Field(Constants.EMAIL) String username,
                                  @Field(Constants.PASSWORD) String password,
                                  @Field(Constants.FIRST_NAME) String firstName,
                                  @Field(Constants.LAST_NAME) String lastName,
                                  @Field(Constants.CONTACT) String contact,
                                  @Field(Constants.BIRTHDAY) String birthday,
                                  @Field(Constants.ADDRESS) String address
    );

    @FormUrlEncoded
    @POST(Endpoints.VERIFY)
    Call<ResultResponse> verify(@Field(Constants.EMAIL) String email,
                                @Field(Constants.VER_CODE) String code);


    @Multipart
    @POST("updateUserWithImage")
    Call<User> updateUserWithImage(@Part MultipartBody.Part image,
                                   @Part(Constants.USER_ID) RequestBody user_id,
                                   @Part(Constants.FIRST_NAME) RequestBody first_name,
                                   @Part(Constants.LAST_NAME) RequestBody last_name,
                                   @Part(Constants.CONTACT) RequestBody contact,
                                   @Part(Constants.BIRTHDAY) RequestBody birthday,
                                   @Part(Constants.ADDRESS) RequestBody address);


    @FormUrlEncoded
    @POST(Endpoints.CLIENT)
    Call<User> updateUser(@Field(Constants.TAG) String tag,
                          @Field(Constants.USER_ID) String user_id,
                          @Field(Constants.FIRST_NAME) String first_name,
                          @Field(Constants.LAST_NAME) String last_name,
                          @Field(Constants.CONTACT) String contact,
                          @Field(Constants.BIRTHDAY) String birthday,
                          @Field(Constants.ADDRESS) String address);


    @FormUrlEncoded
    @POST(Endpoints.CLIENT)
    Call<ResultResponse> changePassword(@Field(Constants.TAG) String tag,
                                        @Field(Constants.USER_ID) String user_id,
                                        @Field(Constants.PASSWORD) String password);



    @FormUrlEncoded
    @POST(Endpoints.CLIENT)
    Call<ResultResponse> checkEmail(@Field(Constants.TAG) String tag, @Field(Constants.EMAIL) String email);

    @FormUrlEncoded
    @POST(Endpoints.COMPANY)
    Call<List<Company>> getCompanies(@Field(Constants.TAG) String tag,@Field(Constants.TYPE) String type);



    @FormUrlEncoded
    @POST(Endpoints.EMERGENCY)
    Call<List<Emergency>> getEmergency(@Field(Constants.TAG) String tag, @Field(Constants.USER_ID) String user_id );


    @FormUrlEncoded
    @POST(Endpoints.EMERGENCY)
    Call<List<Emergency>> deleteEmergency(@Field(Constants.TAG) String tag, @Field(Constants.USER_ID) String user_id, @Field(Constants.CONTACT_ID) String contact_id );


    @FormUrlEncoded
    @POST(Endpoints.EMERGENCY)
    Call<List<Emergency>> updateEmergency(@Field(Constants.TAG) String tag, @Field(Constants.CONTACT_ID) String emergency_id, @Field(Constants.CONTACT_NAME) String name,@Field(Constants.CONTACT_NUMBER) String contact);



    @FormUrlEncoded
    @POST(Endpoints.EMERGENCY)
    Call<List<Emergency>> addEmergency(@Field(Constants.TAG) String tag, @Field(Constants.USER_ID) String user_id, @Field(Constants.CONTACT_NAME) String name,@Field(Constants.CONTACT_NUMBER) String contact);



    @FormUrlEncoded
    @POST("checkAnswer")
    Call<ResultResponse> checkAnswer(@Field(Constants.EMAIL) String email,
                                     @Field(Constants.QUESTION) String question,
                                     @Field(Constants.ANSWER) String answer);

    @FormUrlEncoded
    @POST(Endpoints.VERIFY_RESEND_EMAIL)
    Call<ResultResponse> verifyResendEmail(@Field(Constants.USER_ID) String user_id);


    @Multipart
    @POST("upload.php")
    Call<ResultResponse> uploadImage(@Part MultipartBody.Part image);




    @POST("setAppointment")
    @FormUrlEncoded
    Call<ResultResponse> setAppointment(@FieldMap Map<String, String> params);


   /* @POST("getAppointments")
    @FormUrlEncoded
    Call<List<Appointment>> getAppointments(@Field("user_id") String user_id);*/
}
