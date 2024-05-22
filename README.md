# IceAC
 Karhu anticheat skid made by winterlegends skidders

Please note that you need to drop Skidders.jar into plugins folder for it to work.

Example below

public final class SkiddersListener implements SkidListener {

    public ExampleListener() {
        SkidAPI.getEventRegistry().addListener(this);
    }

    @Override
    public void onEvent(SkidEvent event) {

        if(event instanceof SkidAlertEvent){
           final CheckData check = ((SkidAlertEvent) event).getCheck();
           final Player player = ((SkidAlertEvent) event).getPlayer();
        }

    }

}

