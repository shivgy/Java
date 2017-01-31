
private void processClient(final InputStream in) throws IOException {
		final BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		final char[] cbuf = new char[1024];
		final int length = reader.read(cbuf);
		if (length <= 0) {
			logger.warn("No data read from client.");
			return;
		}
		cbuf[length] = '@';
		String packet = new String(cbuf, 0, length + 1); 
		logger.info("Recieved packet: " + packet + " Connection From : " + getId());

		try
		{
			packet = packet.substring(packet.indexOf('$'), packet.indexOf('@'));
			final String [] temppackets=packet.split("#");
			for(int i=0;i<temppackets.length;i++)
			{
				if(temppackets[i].toString().length() >2)
				{
					final String pack = temppackets[i]+"#";
					final Packet packetDTO = parsePacket(pack);
					final OutputStream out = clientSocket.getOutputStream();
					if (packetDTO.cmdId.startsWith("$SUNSTART")) {
						final String response = "$SUNSTARTRES|" + packetDTO.uId + "|#";
						writeResponse(out, response);
						clientModel.addClient(packetDTO.unitId, this);  
						logger.info("New client added...");
					}
					else if (packetDTO.cmdId.startsWith("$SUNALERT")){
						final String response = "$SUNALERTACK|" + packetDTO.uId + "|#";
						writeResponse(out, response); 
						logger.info("Sending AlertAck to client:" + response);
					}
					else if(packetDTO.cmdId.startsWith("$SUNPOLL")){
						final String response = "$SUNCMDACK|" + packetDTO.uId + "|#"; 
						writeResponse(out, response); 
					}    
					splitandCallStoredProcedure(pack.replaceAll("(\\r|\\n)", ""));  
				}
			}
		}catch (Exception e) { 
			logger.info(e.toString());
		}
	}
