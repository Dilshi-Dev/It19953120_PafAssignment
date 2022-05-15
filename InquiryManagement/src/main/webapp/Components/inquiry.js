$(document).ready(function()
{
	if ($("#alertSuccess").text().trim() == "")
 	{
 	$("#alertSuccess").hide();
 	}
 	$("#alertError").hide();
});

//SAVE
$(document).on("click", "#btnSave", function(event)
{
	// Clear alerts---------------------
	$("#alertSuccess").text("");
 	$("#alertSuccess").hide();
 	$("#alertError").text("");
 	$("#alertError").hide();
 	
 	// Form validation-------------------
	var status = validateInquiryForm();
	if (status != true)
	{
	$("#alertError").text(status);
	$("#alertError").show();
	return;
	}
	
	// If valid-------------------------
 	var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT";
	
	$.ajax(
 	{
 	url : "InquiryServlet",
 	type : type,
 	data : $("#formInquiry").serialize(),
 	dataType : "text",
 	complete : function(response, status)
 	{
 		onInquirySaveComplete(response.responseText, status);
 	}
 	});
 
});

function onInquirySaveComplete(response, status)
{
	if (status == "success")
 	{
 		var resultSet = JSON.parse(response);
 		
 		if (resultSet.status.trim() == "success")
 		{
 			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			
			$("#divItemsGrid").html(resultSet.data);
 		} else if (resultSet.status.trim() == "error")
 		{
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
 		}
 	} else if (status == "error")
 	{
 		$("#alertError").text("Error while saving.");
 		$("#alertError").show();
 	} else
 	{
 		$("#alertError").text("Unknown error while saving..");
 		$("#alertError").show();
 	} 
 	$("#hidInquiryCodeSave").val("");
 	$("#formInquiry")[0].reset();
}

// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
{
	console.log("Update",$("#hidInquiryCodeSave").val());
	$("#hidInquiryCodeSave").val($(this).closest("tr").find('#hidInquiryCodeUpdate').val());
	 $("#hidInquiryCodeSave").val($(this).data("code"));
	 //$("#code").val($(this).closest("tr").find('td:eq(0)').text());
	 $("#cusID").val($(this).closest("tr").find('td:eq(0)').text());
	 $("#cusName").val($(this).closest("tr").find('td:eq(1)').text());
	 $("#eleAccNo").val($(this).closest("tr").find('td:eq(3)').text());
	 $("#address").val($(this).closest("tr").find('td:eq(2)').text());
	 $("#email").val($(this).closest("tr").find('td:eq(3)').text());
	 $("#contact").val($(this).closest("tr").find('td:eq(3)').text());
	 $("#type").val($(this).closest("tr").find('td:eq(3)').text());
	 $("#massage").val($(this).closest("tr").find('td:eq(3)').text());
	 $("#status").val($(this).closest("tr").find('td:eq(3)').text());
});

$(document).on("click", ".btnRemove", function(event)
{
 	$.ajax(
 	{
 		url : "InquiryServlet",
 		type : "DELETE",
 		data : "code=" + $(this).data("code"),
 		dataType: "text",
 		complete : function(response, status)
 		{
 			onInquiryDeleteComplete(response.responseText, status);
 		}
 	});
});

function onInquiryDeleteComplete(response, status)
{
	if (status == "success")
 	{
 		var resultSet = JSON.parse(response);
 		if (resultSet.status.trim() == "success")
 		{
			 $("#alertSuccess").text("Successfully deleted.");
			 $("#alertSuccess").show();
			 
			 $("#divInquiryGrid").html(resultSet.data);
 		} else if (resultSet.status.trim() == "error")
 		{
			 $("#alertError").text(resultSet.data);
			 $("#alertError").show();
 		}
 		} else if (status == "error")
 		{
			 $("#alertError").text("Error while deleting.");
			 $("#alertError").show();
 		} else
		{
			 $("#alertError").text("Unknown error while deleting..");
			 $("#alertError").show();
 		}
}

// CLIENT-MODEL================================================================
function validateItemForm()
{
	// CONTACT
	let contact = $("#contact").val().trim();
	if (!$.isNumeric(contact)) {
		return "Please Enter valid Contact Number.";
	}
	 
	// ADDRESS
	if ($("#address").val().trim() == "")
	 {
	 return "Invalid Address.";
	 } 
	 
	// CUSTOMER ID
	if ($("#cusID").val().trim() == "")
	 {
	 return "Please Enter Valid Customer ID";
	 }
	 
	// Electronic Account Number
	let eleAccNo = $("#eleAccNo").val().trim();
	if (!$.isNumeric(eleAccNo)) {
		return "please Enter Correct Account Number.";
	}
	 
	return true;
}

