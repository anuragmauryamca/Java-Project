package in.opalina.iso;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;

public class UnpackIsoMessage {
	
	public static void main(String[] args) throws ISOException {
        
        GenericPackager packager = new GenericPackager(
                "src/in/opalina/iso/iso87ascii.xml");
 
        ISOMsg isoMsg = new ISOMsg();
        isoMsg.setPackager(packager);
 
        String isoMessage = "010032200000000100000200000000000050000804170346123456013Example Value";
 
        byte[] bIsoMessage = new byte[isoMessage.length()];
        for (int i = 0; i < bIsoMessage.length; i++) {
            bIsoMessage[i] = (byte) (int) isoMessage.charAt(i);
        }
 
        isoMsg.unpack(bIsoMessage); 
 
        
        System.out.println("MTI='"+isoMsg.getMTI()+"'");
        for(int i=1; i<=isoMsg.getMaxField(); i++){
            if(isoMsg.hasField(i))
                System.out.println(i+"='"+isoMsg.getString(i)+"'");
        }
    }

}
