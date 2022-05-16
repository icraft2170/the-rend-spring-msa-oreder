package dev.practice.order.domain.partner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PartnerServiceImpl implements PartnerService {
    private final PartnerStore partnerStore;
    private final PartnerReader partnerReader;

    @Override
    public PartnerInfo registerPartner(PartnerCommand command) {
        // 1. command -> InitPartner
        // 2. InitPartner save to DB
        // 3. Partner -> PartnerInfo AND return
        var initPartner = command.toEntity();
        Partner partner = partnerStore.store(initPartner);
        return new PartnerInfo(partner);
    }

    @Override
    public PartnerInfo getPartnerInfo(String partnerToken) {
        // 1. partnerToken -> Partner
        // 2. Partner -> PartnerInfo AND Return
        Partner partner = partnerReader.getPartner(partnerToken);
        return new PartnerInfo(partner);
    }

    @Override
    public PartnerInfo enablePartner(String partnerToken) {
        // 1. partnerToken -> Partner
        // 2. Partner.enable()
        Partner partner = partnerReader.getPartner(partnerToken);
        partner.enable();
        return new PartnerInfo(partner);
    }

    @Override
    public PartnerInfo disablePartner(String partnerToken) {
        // 1. partnerToken -> Partner
        // 2. Partner.disable()
        Partner partner = partnerReader.getPartner(partnerToken);
        partner.disable();
        return new PartnerInfo(partner);
    }
}
