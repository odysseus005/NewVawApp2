package jazevangelio.newvawepp;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by User on 2/28/2017.
 */

public class Tab5Fragment extends Fragment {
    private static final String TAG = "Tab3Fragment";
    public Button num1, num2, num3, num4, num5, num6, num7, num8, num9, num10, num11, num12, num13, num14, num15;
    private Uri uri;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.helpdesk5_fragment,container,false);
//
//        num1 = (Button) myView.findViewById(R.id.btnHot1);
//        num2 = (Button) myView.findViewById(R.id.btnHot2);
//        num3 = (Button) myView.findViewById(R.id.btnHot3);
//        num4 = (Button) myView.findViewById(R.id.btnHot4);
//        num5 = (Button) myView.findViewById(R.id.btnHot5);
//        num6 = (Button) myView.findViewById(R.id.btnHot6);
//        num7 = (Button) myView.findViewById(R.id.btnHot7);
//        num8 = (Button) myView.findViewById(R.id.btnHot8);
//        num9 = (Button) myView.findViewById(R.id.btnHot9);
//        num10 = (Button) myView.findViewById(R.id.btnHot10);
//        num11 = (Button) myView.findViewById(R.id.btnHot11);
//        num12 = (Button) myView.findViewById(R.id.btnHot12);
//        num13 = (Button) myView.findViewById(R.id.btnHot13);
//        num14 = (Button) myView.findViewById(R.id.btnHot14);
//        num15 = (Button) myView.findViewById(R.id.btnHot15);
//
//        num1.setOnClickListener(onClickListener);
//        num2.setOnClickListener(onClickListener);
//        num3.setOnClickListener(onClickListener);
//        num4.setOnClickListener(onClickListener);
//        num5.setOnClickListener(onClickListener);
//        num6.setOnClickListener(onClickListener);
//        num7.setOnClickListener(onClickListener);
//        num8.setOnClickListener(onClickListener);
//        num9.setOnClickListener(onClickListener);
//        num10.setOnClickListener(onClickListener);
//        num11.setOnClickListener(onClickListener);
//        num12.setOnClickListener(onClickListener);
//        num13.setOnClickListener(onClickListener);
//        num14.setOnClickListener(onClickListener);
//        num15.setOnClickListener(onClickListener);

        return myView;
    }
//
//    private View.OnClickListener onClickListener = new View.OnClickListener() {
//
//        @Override
//        public void onClick(final View v) {
//            switch(v.getId()){
//                case R.id.btnHot1:
//                    uri = Uri.parse("tel: 415-6390");
//                    intentHere();
//                    break;
//                case R.id.btnHot2:
//                    Uri.parse("tel: 709-7481");
//                    intentHere();
//                    break;
//                case R.id.btnHot3:
//                    Uri.parse("tel: 426-4289");
//                    intentHere();
//                    break;
//                case R.id.btnHot4:
//                    Uri.parse("tel: 681-5921");
//                    intentHere();
//                    break;
//                case R.id.btnHot5:
//                    Uri.parse("tel: 681-8078");
//                    intentHere();
//                    break;
//                case R.id.btnHot6:
//                    Uri.parse("tel: 434-2149");
//                    intentHere();
//                    break;
//                case R.id.btnHot7:
//                    Uri.parse("tel: 526-9098");
//                    intentHere();
//                    break;
//                case R.id.btnHot8:
//                    Uri.parse("tel: 913-0875");
//                    intentHere();
//                case R.id.btnHot9:
//                    Uri.parse("tel: 734-2366");
//                    intentHere();
//                case R.id.btnHot10:
//                    Uri.parse("tel: 239-4304");
//                    intentHere();
//                case R.id.btnHot11:
//                    Uri.parse("tel: 826-0061");
//                    intentHere();
//                case R.id.btnHot12:
//                    Uri.parse("tel: 726-2771");
//                    intentHere();
//                case R.id.btnHot13:
//                    Uri.parse("tel: 832-1150");
//                    intentHere();
//                case R.id.btnHot14:
//                    Uri.parse("tel: 563-6363");
//                    intentHere();
//                case R.id.btnHot15:
//                    Uri.parse("tel: 434-2149");
//                    intentHere();
//                    break;
//                default:
//                    break;
//            }
//
//        }
//    };
//
//    public void intentHere(){
//        Intent intent = new Intent(Intent.ACTION_CALL);
//        intent.setData(uri);
//        startActivity(intent);
//    }

}
