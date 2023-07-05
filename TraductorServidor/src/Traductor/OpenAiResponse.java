/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Traductor;

import java.util.List;

/**
 *
 * @author MIRKO
 */
class Choice{
    public String text;
    public int index;
    public Object logprobs;
    public String finish_reason;
}
class Usage{
    public int prompt_tokens;
    public int completion_token;
    public int total_tokens;
}
public class OpenAiResponse {
    public String id;
    public String objected;
    public int created;
    public String model;
    public List<Choice> choices;
    public Usage usage;
    
    public OpenAiResponse(){
    
    }
    public String getResponse(){
        return choices.get(0).text;
    }
}
