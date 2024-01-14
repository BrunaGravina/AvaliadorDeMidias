package br.com.modelos.bru;

public record TitleOmdb(String title, String year, String runtime) {
    public static class YearConversionErrorException extends Throwable {
        public YearConversionErrorException(String s) {
        }
    }
}
