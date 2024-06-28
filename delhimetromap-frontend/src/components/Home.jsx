import { Box, Button, Card, FormGroup, Grid, InputLabel, MenuItem, Select, Stack, Typography } from '@mui/material';
import React, { useEffect, useState } from 'react'
import Station from './Station';
import axios from 'axios';

const Home = () => {
   

    // 34
    const [source, setSource] = useState('');
    const [destination, setDestination] = useState('');
    const [path, setPath] = useState([]);
    const [stations, setStations] = useState([]);

    useEffect(()=>{
        try {
            axios.get("http://localhost:8080/allStations").then((res)=>{
                setStations(res.data);   
            });
        }
        catch(e) {
            console.log(e);
        }

    }, [])

    const doit = ()=> {
         try { 
            axios.get(`http://localhost:8080/shortestRoute?src=${source}&dest=${destination}`).then((res)=>setPath(res.data));
         }
         catch(e) {
            console.log(e);
         }
    }
  return (
    <Stack sx={{ backgroundColor:'#FBFCF8', minHeight:'85vh', width:'100vw', flexDirection:{xs:'column', md:'row'}, justifyContent:'center', alignItems:'center', marginTop:'12vh'}}>
        <Box sx={{ height:{xs:'45vh', md:'85vh'}, width:{xs:'100%', md:'30%'}, display:'flex', justifyContent:'center', alignItems:'flex-start', paddingTop:'5vh', marginRight:'5vw'}}>
            <Card variant='elevation' sx={{ position:{xs:'static', md:'fixed'}, top:'20vh', left:'5vw', height:{xs:'40vh', md:'60vh'}, width:{xs:'80vw', md:'21vw'}, backgroundColor:'#039be5', flexDirection:'column', display:'flex', justifyContent:'center', alignItems:'center'}}>
                <FormGroup sx={{width:'100%', height:'70%', display:'flex', justifyContent:'center', alignItems:'center', textAlign:'left'} }>
                    <Typography fontSize="1.5rem" sx={{fontWeight:'600', color:'white'}}>Find shortest route</Typography>
                    <Box sx={{ width:'80%', textAlign:'left', marginBottom:'1vh'}}> 
                        <InputLabel sx={{fontWeight:'800'}}> From </InputLabel>
                    </Box>
                    <Select
                        value={source}
                        placeholder='Select a station'
                        onChange={(e)=>{setSource(e.target.value)}}
                        sx={{width:'80%', border:'1.5px solid black'}}
                    >
                        {
                        stations.map((station)=>(
                            <MenuItem
                            key={station.id}
                            value={station.id}
                          >
                            {station.name}
                          </MenuItem>
                        ))}
                    </Select>
                    <Box sx={{ width:'80%', textAlign:'left', marginBottom:'1vh'}}> 
                        <InputLabel sx={{fontWeight:'800'}}>To</InputLabel>
                    </Box>
                    <Select
                        value={destination}
                        placeholder='Select a station'
                        onChange={(e)=>{setDestination(e.target.value)}}
                        sx={{width:'80%', border:'1.5px solid black'}}
                    >
                        {stations.map((station)=>(
                            <MenuItem
                            key={station.id}
                            value={station.id}
                          >
                            {station.name}
                          </MenuItem>
                        ))}
                    </Select>
                </FormGroup>
                <Button sx={{borderRadius:'10px', height:'50px', width:'90px', background:'#FBFCF8', color:'#039be5', fontWeight:'600', ":hover":{color:'black'}}} onClick={doit} variant='outlined'>Find</Button>
            </Card>
        </Box>
        <Box sx={{ width:{xs:'80%', md:'55%'}, display:'flex', justifyContent:'center', alignItems:'center', flexDirection:'column', gap:'3px'}}>
            {path.map((station)=>(
                <Station key={station.id} name={station.name} line={station.line} />
            ))}
        </Box>
    </Stack>
  )
}
export default Home;