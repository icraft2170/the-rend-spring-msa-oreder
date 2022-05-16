package dev.practice.order.domain.partner;

public interface PartnerService {
    //COMMAND(명령)  , CRITERIA(조회) --- INFO
    PartnerInfo registerPartner(PartnerCommand command);
    PartnerInfo getPartnerInfo(String partnerToken);
    PartnerInfo enablePartner(String partnerToken);
    PartnerInfo disablePartner(String partnerToken);
}
