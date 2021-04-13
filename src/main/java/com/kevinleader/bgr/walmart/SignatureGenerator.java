package com.kevinleader.bgr.walmart;

import java.io.ObjectStreamException;
import java.security.KeyRep;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.*;

import org.apache.commons.codec.binary.Base64;

public class SignatureGenerator {

    public static void main(String[] args) {
        SignatureGenerator generator = new SignatureGenerator();

        String consumerId = "3051ce7e-1c49-42ca-9fac-0ea9fa6893c6";
        String priviateKeyVersion = "1";
        String privateKey = "D4G0kLktLLJZsTkCoA8TPgHwE3stvujyfffCyb4Kx+iJAYJvwG2MCKN8qI5xEFoc" +
                "0McOqXztj5h8BG6rMtoe/j95znoRHcUKvWh4x1uORSvZ+WWiJ0OFIXTBMZ50N4a2" +
                "pknc0dMnK5dN5lMyEnqJvI8wuso1gy3XHEd5RH9qH1RM7lm0Q4K7ypwkBLCxqpMZ" +
                "isA/JfGuyyxBVDXaLpF7596e1I/ceVX9ttHB0o/dPuQQsStvEZd1w4+5oL8axfiB" +
                "d7JWa1Pij7E+e4SiXcnwmmpBf8DHBLh8Tl2nSQUno9u+8gOgDBW6I8J2SNm/qkEw" +
                "Wbyk6ZLq8nTMKJrLKuJhtKzW+8vDtLxoGGSzz560P15P0dwuoRNb9ZWYG2FYyTVL" +
                "goEqhMmdV9e+3yO31OnkPlI57VOdh6J5eEXkEggVF2El3hR0msF4KjPzk9AQRWvY" +
                "Vxv/8qPP/JT8kXou9mWVrz4yJlfSb9SissorP3hmUgmpxBY4U8I4BBRE+CMpHw7C" +
                "hJxVePAaQEKhch2N2PHQx+pHGxethpMbHIqGuh5pndWHg+7gxenBP1x7DJsn9F3j" +
                "5sVCujixQoCTOi2IgaPt9XI3Au4YOUdbWlPTvy5oJwIQbon2dXdQkW7CT17PBXeB" +
                "J0qnbptEEnvzRTs+ZnmgWeWiaK1fj5y4Qkz+dYwMoPB2cLZPSok32H/pKs4yP2TY" +
                "fP3kPLTVTvWiq+L5mUrS9fpKoM28Cs+4NNWl66JB6LLbmlyZK5FpElmJRwsZSajd" +
                "SAFVFlCU/b+3XEC+x5upMTMtk7mnBsnc5La1USFG8NZQ8UNzCMWwnN0Dj4siOfnj" +
                "1cKFSWlAYPlrA+s3umBVDjy1ZnJROo6e+EjSt45641JwwifPOczInv048BXc8nBP";

        long intimestamp = System.currentTimeMillis();

        System.out.println("consumerId: " + consumerId);
        System.out.println("intimestamp: " + intimestamp);

        Map<String, String> map = new HashMap<>();
        map.put("WM_CONSUMER.ID", consumerId);
        map.put("WM_CONSUMER.INTIMESTAMP", Long.toString(intimestamp));
        map.put("WM_SEC.KEY_VERSION", priviateKeyVersion);

        String[] array = canonicalize(map);

        String data = null;

        try {
            data = generator.generateSignature(privateKey, array[1]);
        } catch(Exception e) { }
        System.out.println("Signature: " + data);
    }
    public String generateSignature(String key, String stringToSign) throws Exception {
        Signature signatureInstance = Signature.getInstance("SHA256WithRSA");

        ServiceKeyRep keyRep = new ServiceKeyRep(KeyRep.Type.PRIVATE, "RSA", "PKCS#8", Base64.decodeBase64(key));

        PrivateKey resolvedPrivateKey = (PrivateKey) keyRep.readResolve();

        signatureInstance.initSign(resolvedPrivateKey);

        byte[] bytesToSign = stringToSign.getBytes("UTF-8");
        signatureInstance.update(bytesToSign);
        byte[] signatureBytes = signatureInstance.sign();

        String signatureString = Base64.encodeBase64String(signatureBytes);

        return signatureString;
    }
    protected static String[] canonicalize(Map<String, String> headersToSign) {
        StringBuffer canonicalizedStrBuffer=new StringBuffer();
        StringBuffer parameterNamesBuffer=new StringBuffer();
        Set<String> keySet=headersToSign.keySet();

        // Create sorted key set to enforce order on the key names
        SortedSet<String> sortedKeySet=new TreeSet<String>(keySet);
        for (String key :sortedKeySet) {
            Object val=headersToSign.get(key);
            parameterNamesBuffer.append(key.trim()).append(";");
            canonicalizedStrBuffer.append(val.toString().trim()).append("\n");
        }
        return new String[] {parameterNamesBuffer.toString(), canonicalizedStrBuffer.toString()};
    }

    class ServiceKeyRep extends KeyRep  {
        private static final long serialVersionUID = -7213340660431987616L;
        public ServiceKeyRep(Type type, String algorithm, String format, byte[] encoded) {
            super(type, algorithm, format, encoded);
        }
        protected Object readResolve() throws ObjectStreamException {
            return super.readResolve();
        }
    }
}