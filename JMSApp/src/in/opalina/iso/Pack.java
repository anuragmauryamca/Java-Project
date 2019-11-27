package in.opalina.iso;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;

public class Pack {

	public static void main(String[] args) throws ISOException {
		GenericPackager packager = new GenericPackager("src/in/opalina/iso/iso87ascii.xml");

		ISOMsg isoMsg = new ISOMsg();
		isoMsg.setPackager(packager);

		isoMsg.set(0, "0100");

		isoMsg.set(3, "020000");

		isoMsg.set(4, "5000");

		isoMsg.set(7, new SimpleDateFormat("MMddHHmmss").format(new Date(0)));

		isoMsg.set(11, "123456");

		isoMsg.set(48, "Example Value");


		long startTime = System.currentTimeMillis();

		byte[] bIsoMsg = isoMsg.pack();
		long endTime = System.currentTimeMillis();

		long totalTime = endTime - startTime;

		System.out.println("Execution Pack Time ------->:" + totalTime);

		String isoMessage = "";
		for (int i = 0; i < bIsoMsg.length; i++) {
			isoMessage += (char) bIsoMsg[i];
		}
		System.out.println("Packed ISO8385 Message = '" + isoMessage + "'");
	}
}
