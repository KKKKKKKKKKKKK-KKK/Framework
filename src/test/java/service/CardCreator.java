package service;

import model.Card;

public class CardCreator {
    public static final String TESTDATA_CARD_FIELD="testdata.card.%s";

    public static Card getCardField(String field){
        String feildtName = String.format(TESTDATA_CARD_FIELD, field);
        return new Card(TestDataReader.getTestData(feildtName));
    }


}
