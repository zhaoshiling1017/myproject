package models.encode;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class EncryptAES
{
    /**
     * 16�����ַ�����
     */
    private final static String[] hexDigits =
            {
            "0", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "a", "b", "c", "d", "e", "f"};
    /**
     * AES�ܳ�
     */
    private final static byte[] keyByte =
            {
            0x11, 0x22, 0x4F, 0x58, (byte)0x88, 0x10, 0x40, 0x38,
            0x28, 0x25, 0x79, 0x51, (byte)0xCB, (byte)0xDD, 0x55,
            0x66}; //16�ֽڵ���Կ,���Ըı�
    /**
     * һλByte��16�����ַ��ת��
     * @param b byte
     * @return String
     */
    private static String byteToHexString(byte b)
    {
        int n = b;
        if(n < 0)
        {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    /**
     * Byte���鵽16�����ַ��ת��
     * @param b byte[]
     * @return String
     */
    private static String byteArrayToHexString(byte[] b)
    {
        StringBuffer resultSb = new StringBuffer();
        for(int i = 0; i < b.length; i++)
        {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    /**
     * 16�����ַ�Byteת��
     * @param b String
     * @return byte
     */
    private static byte HexStringTobyte(String b)
    {
        int By = 0;
        String b1 = b.substring(0, 1);
        int b11 = -1;
        String b2 = b.substring(1);
        int b12 = -1;
        for(int i = 0; i < 16; i++)
        {
            if(b1.equals(hexDigits[i]))
            {
                b11 = i;
            }
        }
        for(int i = 0; i < 16; i++)
        {
            if(b2.equals(hexDigits[i]))
            {
                b12 = i;
            }
        }
        By = b11 * 16 + b12;
        if(By > 256)
        {
            By = By - 256;
        }
        return(byte)By;
    }

    /**
     * 16�����ַ�Byte�����ת��
     * @param b String
     * @return byte[]
     */
    private static byte[] HexStringTobyteArray(String b)
    {
        byte[] r = new byte[32];
        for(int i = 0; i < b.length() / 2; i++)
        {
            r[i] = HexStringTobyte(b.substring(i * 2, i * 2 + 2));
        }
        return r;
    }

    /**
     * MD5����
     * @param OriString String
     * @return String
     * @throws Exception
     */
    private static String EncodeMD5(String OriString) throws Exception
    {
        String resultString = null;
        resultString = new String(OriString);
        MessageDigest md = MessageDigest.getInstance("MD5");
        resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
        return resultString;
    }

    /**
     * AES����
     * @param OriString String
     * @return String
     * @throws Exception
     */
    private static String EnCodeAES(String OriString) throws Exception
    {
        byte[] OriByte = OriString.getBytes("GBK");
        //ͨ��SecretKeySpec�γ�һ��key
        SecretKey key = new SecretKeySpec(keyByte, "AES");
        //���һ��˽�_������Cipher��ECB�Ǽ��ܷ�ʽ��PKCS5Padding����䷽��
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        //ʹ��˽�_����
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] OriCipherText = cipher.doFinal(OriByte);
        String b = byteArrayToHexString(OriCipherText);
        return b; //���룬ת����16����
    }

    /**
     * AES����
     * @param OriString String
     * @return String
     * @throws Exception
     */
    private static String DeCodeAES(String OriString) throws Exception
    {
        //ͨ��SecretKeySpec�γ�һ��key
        SecretKey key = new SecretKeySpec(keyByte, "AES");
        //���һ��˽�_������Cipher��ECB�Ǽ��ܷ�ʽ��PKCS5Padding����䷽��
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        //ʹ��˽�_����
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] NewCipherText = Hex.fromString(OriString);
        byte[] newString = cipher.doFinal(NewCipherText);
        return new String(newString, "GBK");
    }

    public static String EnCode(String OriString)
    {
        try
        {
                return EnCodeAES(OriString);
        }
        catch(Exception e)
        {
            return null;
        }
    }

    public static String DeCode(String OriString)
    {
        try
        {
            return DeCodeAES(OriString);
        }
        catch(Exception e)
        {
            return null;
        }
    }

    public static void main(String[] args)
    {
        System.out.println(EncryptAES.EnCode("123456sdsds#443S"));
        try {
			System.out.println(EncryptAES.DeCode("d9456d55ce9fcf347022268b8568a44dfee20a135595045a219b45ddb10f952d"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

    }

}
