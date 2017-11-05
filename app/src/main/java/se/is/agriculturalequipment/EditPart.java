package se.is.agriculturalequipment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import se.is.agriculturalequipment.DAO.PartDAO;
import se.is.agriculturalequipment.model.PartList;

public class EditPart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_part);

        //Get object PartList from SettingPart.
        final PartList edtPartList = (PartList) getIntent().getSerializableExtra("editPartList");
        final String tblName = getIntent().getStringExtra("tblName");
        Button btnSaveEdit = (Button) findViewById(R.id.btnSaveEdit);
//        Log.d("tblname editpart", tblName);

        final EditText edtName = (EditText) findViewById(R.id.edtName);
        final EditText edtPrice = (EditText)findViewById(R.id.edtPrice);
        edtName.setText(edtPartList.getPartname());
        edtPrice.setText(edtPartList.getPartPrice());

        btnSaveEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PartList mEdtPartList = new PartList();
                mEdtPartList.setId(edtPartList.getId());
                mEdtPartList.setPartname(String.valueOf(edtName.getText()));
                mEdtPartList.setPartPrice(String.valueOf(edtPrice.getText()));

//                Log.d("partName : ", String.valueOf(edtName.getText()));
//                Log.d("partPrice : ", String.valueOf(edtPrice.getText()));

                PartDAO partDAO = new PartDAO(getApplicationContext());
                partDAO.open();
                partDAO.update(mEdtPartList,tblName);
                partDAO.close();

                finish();
            }
        });
    }
}
