 TextView textView = (TextView)findViewById(R.id.textview);

final String text  = textView.getText().toString();

textView.setOnClickListener(new OnClickListener() {

@Override
public void onClick(View arg0) {

ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
ClipData clip = ClipData.newPlainText("label", text);
clipboard.setPrimaryClip(clip);

}

});
