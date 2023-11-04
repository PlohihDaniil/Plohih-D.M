public class ConnectorBD {
    private static ConnectorBD connectorBD;
    private static BD bd = new BD();

    public static ConnectorBD getConnectorBD(){
        if(connectorBD == null){
            connectorBD = new ConnectorBD();
        }
        return connectorBD;
    }

    public ConnectorBD() {

    }

    public void showBD(){
        System.out.println(bd.getList());
    }

}
