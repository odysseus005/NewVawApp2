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

public class Tab2Fragment extends Fragment {
    private static final String TAG = "Tab2Fragment";
    public Button num1, num2, num3, num4, num5, num6, num7, num8, num9, num10;
    private Uri uri;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.helpdesk2_fragment,container,false);

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
        return myView;
    }
//
//    private View.OnClickListener onClickListener = new View.OnClickListener() {
//
//        @Override
//        public void onClick(final View v) {
//            switch(v.getId()){
//                case R.id.btnHot1:
//                    uri = Uri.parse("tel: 734-8639");
//                    intentHere();
//                    break;
//                case R.id.btnHot2:
//                    Uri.parse("tel: 807-1588");
//                    intentHere();
//                    break;
//                case R.id.btnHot3:
//                    Uri.parse("tel: 651-7800");
//                    intentHere();
//                    break;
//                case R.id.btnHot4:
//                    Uri.parse("tel: 525-8231");
//                    intentHere();
//                    break;
//                case R.id.btnHot5:
//                    Uri.parse("tel: 411-0441");
//                    intentHere();
//                    break;
//                case R.id.btnHot6:
//                    Uri.parse("tel: 410-3213");
//                    intentHere();
//                    break;
//                case R.id.btnHot7:
//                    Uri.parse("tel: 929-9010");
//                    intentHere();
//                    break;
//                case R.id.btnHot8:
//                    Uri.parse("tel: 929-9436");
//                    intentHere();
//                    break;
//                case R.id.btnHot9:
//                    Uri.parse("tel: 353-0667");
//                    intentHere();
//                    break;
//                case R.id.btnHot10:
//                    Uri.parse("tel: 426-1314");
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
