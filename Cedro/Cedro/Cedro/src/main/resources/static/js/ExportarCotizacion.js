function expo() {

	// Get the element.
	var element = document.getElementById('c');
	
	// Generate the PDF.
	html2pdf().from(element).set({
		margin: -50,
		filename: 'Mi_Cotización.pdf',
		html2canvas: { scale: 1 },
		
		
		jsPDF: {
			
			//paddingTop: -200,
			orientation: 'portrait',
			unit: 'mm',
			format: 'c3',
			setPage:(1),
			putOnlyUsedFonts:false,
			precision: 16,
			compress:false
		}

	}).save();

}