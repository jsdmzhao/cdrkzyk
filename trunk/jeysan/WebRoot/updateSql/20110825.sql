create view fhp_fertile_woman_view as
select fw.ID,fw.TYPEH,fw.`CODE`,fw.nameh,fw.AREA,p.age,p.CERT_TYPE,p.`CODE` as cert_Code,p.DOMICILE_TYPE,p.KIND,bc.IS_AGREE,gi.ID as gi_id,gi.RECORD_TYPE,gi.TYPEH as gi_typeh
from fhp_fertile_woman fw 
left join fhp_person p on fw.PERSON_ID=p.ID
left join fhp_birth2_apply ba on ba.WOMAN_ID = fw.ID
left join fhp_birth2_check bc on bc.APPLY_ID = ba.ID
left join FHP_GET_IUD gi on fw.ID = gi.WOMAN_ID
order by fw.id asc