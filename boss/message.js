
	function openMessageBox(){
		var url = "MFServlet?command=SendMessage&mid=";
		window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no",
		width="450", height="200");
				
	}
	
	function closeMessageBox(){
		self.close();
	}
	
	