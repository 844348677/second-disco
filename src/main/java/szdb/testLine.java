package szdb;

import java.util.List;

public class testLine {
	
	static final  String Beoverduesummaryinfo 			=	"Beoverduesummaryinfo.csv";
	static final  String Beoverduesummaryoverview 		=   "Beoverduesummaryoverview.csv";
	static final  String Compulsoryexecutionrecord 		=	"Compulsoryexecutionrecord.csv";
	static final  String Creditcardinfo 				=	"Creditcardinfo.csv";
	static final  String Creditloanapproquerydetailed 	=	"Creditloanapproquerydetailed.csv";
	static final  String Credittipsinfo 				=	"Credittipsinfo.csv";
	static final  String Housingreservepayrecord 		= 	"Housingreservepayrecord.csv";
	static final  String Identityinfo 					=	"Identityinfo.csv";
	static final  String Loaninfo 						=   "Loaninfo.csv";
	static final  String Nocancelcreditcardsummaryinfo 	=	"Nocancelcreditcardsummaryinfo.csv";
	static final  String Nocaquasicreditcardinfosum 	=	"Nocaquasicreditcardinfosum.csv";
	static final  String Nosettledloansummaryinfo 		=	"Nosettledloansummaryinfo.csv";
	static final  String Occupationinfo 				=  	"Occupationinfo.csv";
	static final  String Pboc_credit_overdue 			=  	"Pboc_credit_overdue.csv";
	static final  String Pboc_loan_overdue 				=  	"Pboc_loan_overdue.csv";
	static final  String Pboc_loan_stypes 				= 	"Pboc_loan_stypes.csv";
	static final  String Pboc_qcredit_overdue 			=  	"Pboc_qcredit_overdue.csv";
	static final  String Pensioninsurancepayrecord 		=  	"Pensioninsurancepayrecord.csv";
	static final  String Perguaranteeinfo 				=  	"Perguaranteeinfo.csv";
	static final  String Persummaryguarantee 			=	"Persummaryguarantee.csv";
	static final  String Quasicreditcard 				=  	"Quasicreditcard.csv";
	static final  String Queryrecordsum 				= 	"Queryrecordsum.csv";
	static final  String Reportbasics_main_4 			=  	"Reportbasics_main_4.csv";
	static final  String Resideinfo 					= 	"Resideinfo.csv";
	
	static final  String info_address = "info_address.csv";
	static final  String info_bill = "info_bill.csv";
	static final  String info_credit = "info_credit.csv";
	static final  String info_gavouch = "info_gavouch.csv";
	static final  String info_loan = "info_loan.csv";
	static final  String info_profession = "info_profession.csv";
	static final  String info_qcredit = "info_qcredit.csv";
	static final  String info_query = "info_query.csv";
	static final  String oa_datatoqh_5 = "oa_datatoqh_5.csv";
	static final  String add_info_1 = "add_info_1.csv";
	static final  String add_info_2 = "add_info_2.csv";
	
	static final String newdata = "newdata.csv";
	
	public static void main(String[] args) throws Exception{
		String csvRoot =   "data/sz/"   ; //     "data/sz/"    "data/data_dev/"
		String tableName = newdata;
		
		//InsertUtil.readCsvLine(csvRoot+tableName, ',', "GBK",null);
		
		InsertUtil.readCsvLineNewData(csvRoot+tableName, ',', "GBK",null);

	
		String pyfile = "data/python/x_expert.csv";
		
		InsertUtil.readCsvLine(pyfile, ',', "GBK",null);
	} 
	
	
}
