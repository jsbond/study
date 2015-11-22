package bizbee.common.utils;

import bizbee.common.utils.exception.GoogleServiceException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

public class TimeZoneAPIUtils {

    private static final String DIRECTION_REQUEST_HOST = "maps.googleapis.com/maps/api/timezone/json?";
    private static final String DIRECTION_REQUEST_SERVER_HTTPS = "https://" + DIRECTION_REQUEST_HOST;
    private static final String ENCODING = "UTF-8";

    public String getTimezoneByCoordinates(double latitude, double longitude, long timeStamp) throws GoogleServiceException {
        TimeZoneAPIUtils timeZoneAPIUtils = new TimeZoneAPIUtils();

        JsonObject response;
        try {
            response = timeZoneAPIUtils.getResponse(latitude, longitude, timeStamp);
        } catch (IOException e) {
            throw new GoogleServiceException(e);
        }
        String status;
        try {
            status = response.getAsJsonPrimitive("status").getAsString();
        } catch (Exception e) {
            throw new GoogleServiceException("request was mailformed");
        }
        if (status.equals("OK")) {
            return response.getAsJsonPrimitive("timeZoneId").getAsString();
        } else {
            throw new GoogleServiceException("request was mailformed");
        }
    }

    public JsonObject getResponse(final double latitude, final double longitude, final long timeStamp) throws IOException {
        final String urlString = getURLQuery(latitude, longitude, timeStamp);

        return request(urlString);
    }

    private JsonObject request(final String urlString) throws IOException {
        final URL url = new URL(urlString);
        final Reader reader = new BufferedReader(new InputStreamReader(url.openStream(), ENCODING));
        try {
            return new JsonParser().parse(reader).getAsJsonObject();
        } finally {
            reader.close();
        }
    }

    private String getURLQuery(double latitude, double longitude, long timestamp) throws UnsupportedEncodingException {
        final StringBuilder url = new StringBuilder(DIRECTION_REQUEST_SERVER_HTTPS);

        url.append("location=").append(URLEncoder.encode(Double.toString(latitude), ENCODING));
        url.append(",").append(URLEncoder.encode(Double.toString(longitude), ENCODING));
        url.append("&timestamp=").append(URLEncoder.encode(Long.toString(timestamp), ENCODING));

        return url.toString();
    }
}