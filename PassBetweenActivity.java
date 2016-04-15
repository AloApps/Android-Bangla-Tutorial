 SenderActivity :
Intent intent = new Intent(SenderActivity.this, ReceiverActivity.class);
       intent.putExtra("key", infoModel);
       startActivity(intent);

ReceiverActivity :
Bundle bundle = getIntent().getExtras();
if (bundle != null){
     InfoModel infoModel = (InfoModel) bundle.get("key");
      }
